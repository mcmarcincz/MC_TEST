package modules.bookingHomePageModule

import geb.Module

class FlightChartModule extends  Module{
    static  content =    {
        regularOptionRadioButton(required: false) {$('.one-third.regular .price' )}
    }

    def selectRegularFlight() {
        waitFor {regularOptionRadioButton.isDisplayed()}
        regularOptionRadioButton.click()}
}
