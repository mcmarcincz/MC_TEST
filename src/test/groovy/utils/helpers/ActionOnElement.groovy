package utils.helpers

import geb.module.Checkbox
import geb.module.Select
import geb.module.TextInput
import geb.navigator.Navigator

class ActionOnElement {


    def static selectOptionFromDropDown(Navigator locator, String option) {
        def select = locator.module(Select)
        select.selected = option
    }

    def static enterTextToInputText(Navigator locator, String text) {
        def input = locator.module(TextInput)
        input.text = text
    }

    def static selectCheckBox(Navigator locator) {
        def checkbox = locator.module(Checkbox)

        if (checkbox.isUnchecked()) {
            checkbox.check()
        }
    }
}
