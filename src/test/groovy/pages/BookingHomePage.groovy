package pages
import geb.module.TextInput
import geb.Page
import modules.bookingHomePageModule.FlightChartModule

class BookingHomePage  extends Page {
    static url = "pl/pl/booking/home"
    static at = {  waitFor{ flightPriceChart.isDisplayed() }  }
    static content = {
        flightPriceChart (required:true)    {$('div.flight-list-wrapper' )}
        continueButton (required: false)    {$('.trips-basket.trips-cnt button' )}
        flightChart {module FlightChartModule}
    }

    def continueBooking()
    {continueButton.click()}
}
