package app.tugas.finalproject.feature.team.list

import app.tugas.finalproject.feature.base.BasePresenter
import app.tugas.finalproject.feature.base.BaseView
import app.tugas.finalproject.model.response.League
import app.tugas.finalproject.model.response.ListResponse
import app.tugas.finalproject.model.response.Team

class TeamListContract {

    interface Presenter : BasePresenter {

        fun getLeagueList()

        fun getTeamList(leagueName: String)
    }

    interface View : BaseView {

        fun leagueName() : String

        fun showTeamList(teamResponse: ListResponse<Team>?)

        fun getListLaugue(leagueResponse: ListResponse<League>?)
    }
}