package app.tugas.finalproject.feature.search.event

import app.tugas.finalproject.feature.base.BaseIdleListener
import app.tugas.finalproject.feature.base.BasePresenterImpl
import app.tugas.finalproject.model.Constant
import app.tugas.finalproject.model.response.ListResponse
import app.tugas.finalproject.network.TheSportDBApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class SearchEventPresenterImpl @Inject constructor(
        private val idleListener: BaseIdleListener,
        private val view: SearchEventContract.View,
        private val apiService: TheSportDBApiService)
    : BasePresenterImpl(), SearchEventContract.Presenter {

    override fun searchMatches(query: String) {
        super.addDisposable(apiService.searchEvents(query)
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
}