package app.tugas.finalproject.feature.search.team

import app.tugas.finalproject.feature.base.BasePresenter
import app.tugas.finalproject.feature.base.BaseView
import app.tugas.finalproject.model.response.ListResponse
import app.tugas.finalproject.model.response.Team

class SearchTeamContract {

    interface View : BaseView {
        fun setViewModel(data: ListResponse<Team>)

        fun search(query: String)
    }

    interface Presenter : BasePresenter {
        fun searchTeams(query: String)
    }
}