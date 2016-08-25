package modules.homePageModule

import geb.Module


class SelectAirportsModule extends Module{
    static content = {
        listOfCountries(required: true, wait:true)     { idCountry ->$("popup-content.core-popup-content .pane.left div:nth-child($idCountry)" )}
        listOfCities(required: true, wait:true)        { idCity ->$("popup-content.core-popup-content .pane.right div:nth-child($idCity)" )}
    }

    def selectCountry(idCountry){
        listOfCountries(idCountry).click()
    }
    def selectCity(idCity){
        listOfCities(idCity).click()
    }

}
