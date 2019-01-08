package app.tugas.finalproject.feature.search.event

import app.tugas.finalproject.feature.base.BasePresenter
import app.tugas.finalproject.feature.base.BaseView
import app.tugas.finalproject.model.response.Event
import app.tugas.finalproject.model.response.ListResponse

class SearchEventContract {

    interface  View : BaseView {
        fun setViewModel(data: ListResponse<Event>)

        fun search(query: String)
    }

    interface Presenter : BasePresenter {
        fun searchMatches(query: String)
    }
}