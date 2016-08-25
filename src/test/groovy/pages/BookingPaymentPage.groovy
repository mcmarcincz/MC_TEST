package pages

import geb.Page
import modules.bookingPaymentPageModules.BillingAddressModule
import modules.bookingPaymentPageModules.CardDetailsModule
import modules.bookingPaymentPageModules.PassengerDataModule
import modules.bookingPaymentPageModules.ContactDataModule
import utils.helpers.ActionOnElement


class BookingPaymentPage extends  Page {
    static url = "pl/pl/booking/payment"
    static at = { waitFor { passangerDataHeader.isDisplayed() } }
    static content = {
        passengerData { module PassengerDataModule }
        contactData { module ContactDataModule}
        cardDetails { module CardDetailsModule}
        billingAddress {module BillingAddressModule}
        passangerDataHeader(required: true)             { $(' h2[translate="trips.checkout.passengers.passenger_details"]') }
        acceptTermsCheckbox(required:  true)            { $(".cta  input") }
        payButton(required: true)                       { $(".cta  button ")}
        errorMessage(required:  false)                  {$('prompt.error  div.info-title' )}
    }
    def acceptTerms() {
    ActionOnElement.selectCheckBox(acceptTermsCheckbox)
    }
    def payForFlight(){ payButton.click()}

    def alertMessageWrongPhoneText(){
        waitFor { errorMessage.isDisplayed()}
        errorMessage.text().trim()
    }
}