package app.tugas.finalproject.feature.event.match

import app.tugas.finalproject.feature.base.BaseIdleListener
import app.tugas.finalproject.feature.base.BasePresenterImpl
import app.tugas.finalproject.model.Constant
import app.tugas.finalproject.model.response.ListResponse
import app.tugas.finalproject.network.TheSportDBApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class MatchPresenterImpl @Inject constructor(
        private val idleListener: BaseIdleListener,
        private val view: MatchContract.View,
        private val apiService: TheSportDBApiService)
    : BasePresenterImpl(), MatchContract.Presenter {

    override fun getLastMatch() {
        super.addDisposable(apiService.getLastMatchByLeagueId(view.getSelectedLeagueId().orEmpty())
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
                .onErrorReturn { ListResponse() }
                .subscribe {
                    view.setViewModel(it)
                })
    }

    override fun getNextMatch() {
        super.addDisposable(apiService.getNextMatchByLeagueId(view.getSelectedLeagueId().orEmpty())
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
                .onErrorReturn { ListResponse() }
                .subscribe {
                    view.setViewModel(it)
                })
    }

    override fun getAllLeague() {
        super.addDisposable(apiService.getAllLeagues()
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
                .onErrorReturn { ListResponse() }
                .subscribe {
                    view.setLeagues(it)
                })
    }
}