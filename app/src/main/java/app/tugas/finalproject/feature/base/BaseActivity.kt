package app.tugas.finalproject.feature.base

    import android.content.Context
    import android.os.Bundle
    import android.support.v7.app.AppCompatActivity
    import app.tugas.finalproject.helper.invisible
    import app.tugas.finalproject.helper.visible
    import dagger.android.AndroidInjection
    import org.jetbrains.anko.contentView
    import org.jetbrains.anko.design.snackbar

    abstract class BaseActivity<out T : BasePresenter> : AppCompatActivity(), BaseView {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            AndroidInjection.inject(this)
            onInitView()

            getPresenter()?.run { this.onAttach() }
        }

        protected abstract fun onInitView()

        protected abstract fun getPresenter(): T?

        override fun showMessage(message: String) {
            this.contentView?.rootView?.let {
                snackbar(it, message)
            }
        }

        override fun onDestroy() {
            getPresenter()?.onDetach()
            super.onDestroy()
        }

        override fun showLoading() {
            getProgressBar()?.visible()
        }

        override fun hideLoading() {
            getProgressBar()?.invisible()
        }
    }