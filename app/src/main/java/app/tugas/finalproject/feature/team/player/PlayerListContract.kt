package app.tugas.finalproject.feature.team.player

import app.tugas.finalproject.feature.base.BasePresenter
import app.tugas.finalproject.feature.base.BaseView
import app.tugas.finalproject.model.response.ListResponse
import app.tugas.finalproject.model.response.Player

class PlayerListContract {

    interface View : BaseView {

        fun setPlayerViewModel(players: ListResponse<Player>)
    }

    interface Presenter : BasePresenter {
        fun getListTeamPlayer(teamId: String)
    }
}