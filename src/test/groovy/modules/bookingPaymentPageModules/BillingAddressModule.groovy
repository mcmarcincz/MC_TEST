package modules.bookingPaymentPageModules

import geb.Module
import utils.helpers.ActionOnElement
import utils.objects.BillingAddressObject


class BillingAddressModule extends Module {
static content={
    line1Input(required: true)          {$(" .billing-address  input[id='billingAddressAddressLine1']")}
    line2Input(required: true)          {$(" .billing-address  input[id='billingAddressAddressLine2']")}
    cityInput(required: true)           {$(" .billing-address  input[id='billingAddressCity']")}
    zipCodeInput(required: true)        {$(" .billing-address  input[id='billingAddressPostcode']")}
    countryDropDown(required: true)     {$(" .billing-address  select ")}

}

    def billingAddressData(BillingAddressObject object) {
        waitFor { line1Input.isDisplayed() }
        ActionOnElement.enterTextToInputText(line1Input, object.line1)
        ActionOnElement.enterTextToInputText(line2Input, object.line2)
        ActionOnElement.enterTextToInputText(cityInput, object.city)
        ActionOnElement.enterTextToInputText(zipCodeInput, object.zipCode)
        ActionOnElement.selectOptionFromDropDown(countryDropDown, object.country)
    }
}