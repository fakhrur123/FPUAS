package app.tugas.finalproject.feature.event.detail

import app.tugas.finalproject.feature.base.BasePresenter
import app.tugas.finalproject.feature.base.BaseView
import app.tugas.finalproject.model.entity.EventEntity
import app.tugas.finalproject.model.response.Event
import app.tugas.finalproject.model.response.Team

class MatchDetailContract {

    interface Presenter : BasePresenter {

        fun getDetailEvent()

        fun insertMatchToFavorite(eventEntity: EventEntity)

        fun isExistFavoriteEvent(eventId: String?)

        fun deleteMatchFromFavorite(eventId: String?)
    }

    interface View : BaseView {

        fun isExistFavoriteEvent(isFavorite: Boolean)

        fun getEventId(): String?

        fun setEventDetailModel(event: Event)

        fun setTeamDetailModel(team: Team)
    }
}