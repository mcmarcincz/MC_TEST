package modules.bookingPaymentPageModules

import geb.Module
import utils.helpers.ActionOnElement
import utils.objects.PaymentCardsObject


class CardDetailsModule extends  Module {
    static  content ={
        cardNumberInput(required: false)                {$(" payment-method-card  input[id^='cardNumber']")}
        selectCardTypeDropDown(required: false)         {$(" payment-method-card  select[id^='cardType']")}
        selectMonthDropDown(required:  false)           {$(" payment-method-card  select[id^='expiryMonth']")}
        selectYearDropDown(required: false)             {$(" payment-method-card  select.expiry-year-select")}
        cvvInput(required:  false)                      {$(" payment-method-card  .card-security-code>input")}
        cardHolderInput(required: false)                {$(" payment-method-card  input[name='cardHolderName']")}
    }

    def addCardDetails(PaymentCardsObject object){

        waitFor { cardNumberInput.isDisplayed() }
        ActionOnElement.enterTextToInputText(cardNumberInput, object.cardNumber)
        ActionOnElement.selectOptionFromDropDown(selectCardTypeDropDown, object.cardType)
        ActionOnElement.selectOptionFromDropDown(selectMonthDropDown, object.expiredMonth)
        ActionOnElement.selectOptionFromDropDown(selectYearDropDown, object.expiredYear)
        ActionOnElement.enterTextToInputText(cvvInput, object.cvv)
        ActionOnElement.enterTextToInputText(cardHolderInput, object.cardHolder)
    }

}
