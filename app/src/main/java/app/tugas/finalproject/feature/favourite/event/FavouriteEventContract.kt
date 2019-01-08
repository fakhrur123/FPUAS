package app.tugas.finalproject.feature.favourite.event

import app.tugas.finalproject.feature.base.BasePresenter
import app.tugas.finalproject.feature.base.BaseView
import app.tugas.finalproject.model.entity.EventEntity

class FavouriteEventContract {

    interface Presenter : BasePresenter {
        fun getListFavorite()
    }

    interface View : BaseView {
        fun setViewModel(data: EventEntity)

        fun notifyDataChange()
    }
}