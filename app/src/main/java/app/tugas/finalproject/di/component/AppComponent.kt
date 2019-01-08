package app.tugas.finalproject.di.component

import android.app.Application
import app.tugas.finalproject.di.AppController
import app.tugas.finalproject.di.module.AppModule
import app.tugas.finalproject.di.module.builder.ActivityBuilder
import app.tugas.finalproject.di.scope.ApplicationScope
import app.tugas.finalproject.network.TheSportDBApiService
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule



@ApplicationScope
@Component(modules = [
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class])
interface AppComponent : AndroidInjector<AppController> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun theSportDBApiService(): TheSportDBApiService
}