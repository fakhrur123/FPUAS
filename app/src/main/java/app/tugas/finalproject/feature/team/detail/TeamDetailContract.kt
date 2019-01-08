package app.tugas.finalproject.feature.event.detail

import app.tugas.finalproject.feature.base.BasePresenter
import app.tugas.finalproject.feature.base.BaseView
import app.tugas.finalproject.model.entity.TeamEntity

class TeamDetailContract {

    interface Presenter : BasePresenter {

        fun insertTeamToFavorite(teamEntity: TeamEntity)

        fun isExistFavoriteTeam(teamId: String?)

        fun deleteMatchFromFavorite(teamId: String?)
    }

    interface View : BaseView {

        fun isExistFavoriteTeam(isFavorite: Boolean)

        fun getTeamId(): String?
    }
}