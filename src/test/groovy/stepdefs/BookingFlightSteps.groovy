package stepdefs

import pages.BookingExtrasPage
import pages.BookingHomePage
import pages.BookingPaymentPage
import utils.objects.objectFactoryData.BillingAddressObjectFactory
import utils.objects.objectFactoryData.ContactDataObjectFactory
import utils.objects.objectFactoryData.PaymentCardObjectFactory
import static cucumber.api.groovy.EN.*
import pages.RyanairHomeEnterPage


RyanairHomeEnterPage ryanairHome
BookingHomePage bookingHome
BookingExtrasPage bookingExtras
BookingPaymentPage bookingPayment

Given(~/^Ryanair page open$/) { ->
    to RyanairHomeEnterPage
    at RyanairHomeEnterPage
    page = ryanairHome
    ryanairHome.searchFlight.oneWayRadioFlight()
    ryanairHome.searchFlight.selectAirportFrom(24,14)
    ryanairHome.searchFlight.selectAirportTo(12,1)
    ryanairHome.searchFlight.addDate("11","10","2016" )
    ryanairHome.searchFlight.addPassenger(7)
    ryanairHome.searchFlight.searchFlight()
}


When(~/^User book a flight with incorrect card number$/) { ->
    at BookingHomePage
    bookingHome = page
    bookingHome.flightChart.selectRegularFlight()
    bookingHome.continueBooking()
    at BookingExtrasPage
    bookingExtras = page
    bookingExtras.pay()
    at BookingPaymentPage
    bookingPayment = page
    bookingPayment.passengerData.insertPassengerData(1)
    bookingPayment.passengerData.insertPassengerData(2)
    bookingPayment.contactData.insertContactData(ContactDataObjectFactory.getContactData())
    bookingPayment.cardDetails.addCardDetails(PaymentCardObjectFactory.getPaymentCardObjectData())
    bookingPayment.billingAddress.billingAddressData(BillingAddressObjectFactory.getBillingAddressObjectData())
    bookingPayment.acceptTerms()
    bookingPayment.payForFlight()
}



Then(~/^He will be able to see correct error message$/) { ->
assert bookingPayment.alertMessageWrongPhoneText() == "Oj. Wystąpił problem"
}