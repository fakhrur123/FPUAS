package app.tugas.finalproject.feature.base

import com.airbnb.lottie.LottieAnimationView

open interface BaseView{

    fun getProgressBar() : LottieAnimationView?

    fun showLoading()

    fun hideLoading()

    fun showMessage(message: String)
}