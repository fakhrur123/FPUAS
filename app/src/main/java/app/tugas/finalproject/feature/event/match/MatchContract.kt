package app.tugas.finalproject.feature.event.match

import app.tugas.finalproject.feature.base.BasePresenter
import app.tugas.finalproject.feature.base.BaseView
import app.tugas.finalproject.model.response.Event
import app.tugas.finalproject.model.response.League
import app.tugas.finalproject.model.response.ListResponse

class MatchContract {

    interface Presenter : BasePresenter {

        fun getAllLeague()

        fun getLastMatch()

        fun getNextMatch()
    }

    interface View : BaseView {
        fun getSelectedLeagueId(): String?

        fun setLeagues(leagueResponse: ListResponse<League>?)

        fun setViewModel(eventResponse: ListResponse<Event>?)
    }
}