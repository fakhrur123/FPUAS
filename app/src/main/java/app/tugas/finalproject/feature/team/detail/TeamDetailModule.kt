package app.tugas.finalproject.feature.event.detail

import app.tugas.finalproject.di.scope.ActivityScope
import app.tugas.finalproject.feature.team.detail.TeamDetailActivity
import dagger.Binds
import dagger.Module

@Module
abstract class TeamDetailModule {

    @ActivityScope
    @Binds
    abstract fun provideTeamDetailView(teamDetailActivity: TeamDetailActivity): TeamDetailContract.View

    @ActivityScope
    @Binds
    abstract fun provideTeamPresenter(teamDetailPresenterImpl: TeamDetailPresenterImpl): TeamDetailContract.Presenter
}