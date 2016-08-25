package modules.homePageModule

import geb.Module
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import utils.objects.Driver

class SearchFlightsModule extends Module{

    static content = {
        selectAirport {module SelectAirportsModule}
        selectPassengers {module SelectPassengersModule}
        labelAiportFrom(required: true, wait:true)          { $('[id="label-airport-selector-from"] ' )}
        labelAirportTo (required: true,wait:true)           { $('[id="label-airport-selector-to"] ' ) }
        serchFlightButton(required: true, wait: true)       { $('.col-flight-search-right button' ) }
        oneWayRadioOption(required: true)                   { $('span[id="lbl-flight-search-type-one-way"]')}
        dayInput(required: false )                          { $('input.dd.date-input-0 ' )}
        monthInput(required: false)                         { $('input.mm.date-input-1' )}
        yearInput(required: false)                          { $('input.yyyy.date-input-2' )}
        selectPassengerDropDown(required: false)            { $(".col-passengers" )}
    }


    def clickAction() {
        WebElement element = Driver.getInstance().driver.findElement(By.id("label-airport-selector-from"));
        waitFor {element.displayed}
        Actions builder = new Actions(Driver.getInstance().driver);

        builder.moveToElement(element);
        builder.click();
        builder.build().perform();

    }



    def oneWayRadioFlight() {oneWayRadioOption.click()}

    def selectAirportFrom(idCountry,idCity ) {
        waitFor {labelAiportFrom.isDisplayed()}
        labelAiportFrom.click()
        selectAirport.selectCountry(idCountry)
        selectAirport.selectCity(idCity)
    }

    def selectAirportTo(idCountry,idCity ) {
        waitFor {labelAirportTo.isDisplayed()}
        labelAirportTo.click()
        selectAirport.selectCountry(idCountry)
        selectAirport.selectCity(idCity)
    }

    def addDate(day,month,year ){
        waitFor {dayInput.isDisplayed()}
        dayInput.value(day)
        monthInput.value(month)
        yearInput.value(year)

    }
//id=6 adults, id=7 teens, id=8 children, id=9 infants
    def addPassenger(id){
        selectPassengerDropDown.click()
        waitFor {selectPassengers.adultLabel.isDisplayed()}
        selectPassengers.addPassenger(id)
    }


    def searchFlight() {serchFlightButton.click()}

}
