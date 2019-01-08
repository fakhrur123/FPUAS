package app.tugas.finalproject.feature.favourite.team

import app.tugas.finalproject.feature.base.BasePresenter
import app.tugas.finalproject.feature.base.BaseView
import app.tugas.finalproject.model.entity.TeamEntity

class FavouriteTeamContract {

    interface Presenter : BasePresenter {
        fun getListFavorite()
    }

    interface View : BaseView {
        fun setViewModel(data: TeamEntity)

        fun notifyDataChange()
    }
}