package pages

import geb.Page

class BookingExtrasPage extends Page {

    static url = "pl/pl/booking/extras"
    static at = {  waitFor{ selectSeatButton.isDisplayed() }  }
    static content = {
        selectSeatButton(required: true)        {$('button[translate="trips.extras.leaderboard.quick-card.SEATS.button.select"]' )}
        payButton(required:  true)              {$('.trips-basket.trips-cnt button' )}
        rejectSelectSeatButton(required: false) {$('button[translate="trips.summary.seat.prompt.popup.reject"]') }
    }

    def pay() {
        waitFor { at payButton.isDisplayed() }
        payButton.click()
        waitFor { at rejectSelectSeatButton.isDisplayed() }
        rejectSelectSeatButton.click()

    }

}
