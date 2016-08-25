package modules.bookingPaymentPageModules

import geb.Module
import utils.helpers.ActionOnElement
import utils.objects.objectFactoryData.PassengerObjectFactory


class PassengerDataModule extends  Module{
    static content = {

        selectTitleDropDown(required: false )   {idPassenger ->$(" [name='passengersForm']>passenger-input-group:nth-child($idPassenger)   select ")}
        firstNaneInput(required: false)         {idPassenger ->$("[name='passengersForm']>passenger-input-group:nth-child($idPassenger)   input[id^='firstName' ]")}
        lastNaneInput(required: false)          {idPassenger ->$("[name='passengersForm']>passenger-input-group:nth-child($idPassenger)   input[id^='lastName' ]")}
    }

    def insertPassengerData(idPassenger){
        waitFor { selectTitleDropDown(idPassenger).isDisplayed() }
        ActionOnElement.selectOptionFromDropDown(selectTitleDropDown(idPassenger), PassengerObjectFactory.getPassengerData().title)
        ActionOnElement.enterTextToInputText(firstNaneInput(idPassenger), PassengerObjectFactory.getPassengerData().firstName)
        ActionOnElement.enterTextToInputText(lastNaneInput(idPassenger), PassengerObjectFactory.getPassengerData().lastName)

    }

}
