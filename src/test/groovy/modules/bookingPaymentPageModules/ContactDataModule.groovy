package modules.bookingPaymentPageModules

import geb.Module
import utils.helpers.ActionOnElement
import utils.objects.ContactDataObject


class ContactDataModule extends Module {
    static content = {
        emailAddress(required: true)                { $("[id='payment-contact-form']   input[id^='emailAddress']") }
        confirmEmail(required: true)                { $("[id='payment-contact-form']   input[id^='confirm']") }
        countrySelectDropDown(required:  false)     { $("[id='payment-contact-form']   select ")}
        phoneNumberInput(required: false)           { $("[id='payment-contact-form']  .phone-number>input")}
    }

    def insertContactData(ContactDataObject object){
        waitFor { emailAddress.isDisplayed() }
        ActionOnElement.enterTextToInputText(emailAddress, object.email)
        ActionOnElement.enterTextToInputText(confirmEmail, object.email)
        ActionOnElement.selectOptionFromDropDown(countrySelectDropDown, object.country)
        ActionOnElement.enterTextToInputText(phoneNumberInput, object.phoneNumber)

    }

}