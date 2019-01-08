package app.tugas.finalproject.di.module

import android.app.Application
import android.content.Context
import app.tugas.finalproject.di.scope.ApplicationContext
import app.tugas.finalproject.di.scope.ApplicationScope
import app.tugas.finalproject.feature.base.BaseIdleListener
import app.tugas.finalproject.feature.base.BaseIdleResource
import app.tugas.finalproject.network.NetworkModule
import app.tugas.finalproject.repository.RepositoryModule
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module(includes = [NetworkModule::class, RepositoryModule::class])
class AppModule {

    @ApplicationScope
    @Provides
    @ApplicationContext
    internal fun provideApplication(application: Application) : Application {
        return application
    }

    @ApplicationScope
    @Provides
    internal fun provideContext(@ApplicationContext application: Application) : Context {
        return application
    }

    @Provides
    @Reusable
    internal fun provideBaseIdleResource(): BaseIdleListener = BaseIdleResource
}