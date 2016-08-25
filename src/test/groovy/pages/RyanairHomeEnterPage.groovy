package pages


import geb.Page
import modules.homePageModule.SearchFlightsModule


class RyanairHomeEnterPage extends Page {
    static url = "pl/pl/"
    static at = { waitFor{ logo } ;  waitFor{ searchFlight.searchFlight().isDisplayed() }  }
    static content = {
        searchFlight {module SearchFlightsModule}
        logo (required:true)                {$('a.ryanair-logo' )}
        closeIcon(required: false)          {$('.footer  core-icon[icon-id="glyphs.close"]>div>svg ')}
    }

    def close() {closeIcon.click()}
}
