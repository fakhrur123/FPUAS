package app.tugas.finalproject.feature.favourite.team

import app.tugas.finalproject.feature.base.BaseIdleListener
import app.tugas.finalproject.feature.base.BasePresenterImpl
import app.tugas.finalproject.model.Constant
import app.tugas.finalproject.model.entity.TeamEntity
import app.tugas.finalproject.repository.FavoriteTeamRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class FavouriteTeamPresenterImpl @Inject constructor(
        private val idleListener: BaseIdleListener,
        private val view: FavouriteTeamContract.View,
        private val favoriteRepository: FavoriteTeamRepository
) : BasePresenterImpl(), FavouriteTeamContract.Presenter {

    override fun getListFavorite() {
        return super.addDisposable(favoriteRepository.findAll()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    view.showLoading()
                    idleListener.increment()
                }
                .doOnTerminate {
                    view.hideLoading()
                    idleListener.decrement()
                }
                .doOnError { view.showMessage(Constant.FAILED_GET_DATA) }
                .onErrorReturn { TeamEntity() }
                .doOnComplete {
                    view.hideLoading()
                    view.notifyDataChange()
                }
                .subscribe { view.setViewModel(it) })
    }

}