package app.tugas.finalproject.feature.team.list

import app.tugas.finalproject.feature.base.BaseIdleListener
import app.tugas.finalproject.feature.base.BasePresenterImpl
import app.tugas.finalproject.model.Constant
import app.tugas.finalproject.model.response.ListResponse
import app.tugas.finalproject.network.TheSportDBApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject


class TeamListPresenterImpl @Inject constructor(
        private val idleListener: BaseIdleListener,
        private val view: TeamListContract.View,
        private val apiService: TheSportDBApiService)
    : BasePresenterImpl(), TeamListContract.Presenter {

    override fun getLeagueList() {
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
                    view.getListLaugue(it)
                })
    }

    override fun getTeamList(leagueName: String) {
        super.addDisposable(apiService.getAllTeams(view.leagueName())
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
                    view.showTeamList(it)
                })
    }
}