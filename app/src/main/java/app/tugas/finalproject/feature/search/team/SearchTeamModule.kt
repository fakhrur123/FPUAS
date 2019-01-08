package app.tugas.finalproject.feature.search.team

import app.tugas.finalproject.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class SearchTeamModule {

    @ActivityScope
    @Binds
    abstract fun provideSearchTeam(searchTeamFragment: SearchTeamFragment): SearchTeamContract.View

    @ActivityScope
    @Binds
    abstract fun provideSearchPresenter(searchTeamPresenterImpl: SearchTeamPresenterImpl): SearchTeamContract.Presenter
}