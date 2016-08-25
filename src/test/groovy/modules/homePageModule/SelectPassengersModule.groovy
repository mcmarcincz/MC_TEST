package modules.homePageModule

import geb.Module

class SelectPassengersModule extends Module{

    static content = {
        adultLabel(required:  false)                 {$('[value="paxInput.adults" ]' )}
        addPassengerButton (required: false)        {id -> $("popup-content[ role='listbox']>div:nth-child($id)  button.core-btn.inc" )}
    }
//id=6 adults, id=7 teens, id=8 children, id=9 infants
    def addPassenger(id) {
        addPassengerButton(id).click()
    }
}
