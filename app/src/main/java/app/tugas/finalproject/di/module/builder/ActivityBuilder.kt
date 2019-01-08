package app.tugas.finalproject.di.module.builder

import app.tugas.finalproject.di.scope.ActivityScope
import app.tugas.finalproject.feature.event.detail.MatchDetailActivity
import app.tugas.finalproject.feature.event.detail.MatchDetailModule
import app.tugas.finalproject.feature.event.detail.TeamDetailModule
import app.tugas.finalproject.feature.event.match.MatchFragment
import app.tugas.finalproject.feature.event.match.MatchModule
import app.tugas.finalproject.feature.favourite.event.FavouriteEventFragment
import app.tugas.finalproject.feature.favourite.event.FavouriteEventModule
import app.tugas.finalproject.feature.favourite.team.FavouriteTeamFragment
import app.tugas.finalproject.feature.favourite.team.FavouriteTeamModule
import app.tugas.finalproject.feature.search.event.SearchEventFragment
import app.tugas.finalproject.feature.search.event.SearchEventModule
import app.tugas.finalproject.feature.search.team.SearchTeamFragment
import app.tugas.finalproject.feature.search.team.SearchTeamModule
import app.tugas.finalproject.feature.team.detail.TeamDetailActivity
import app.tugas.finalproject.feature.team.list.TeamListFragment
import app.tugas.finalproject.feature.team.list.TeamListModule
import app.tugas.finalproject.feature.team.player.PlayerListFragment
import app.tugas.finalproject.feature.team.player.PlayerListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [TeamListModule::class])
    internal abstract fun provideTeamListActivity() : TeamListFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [MatchModule::class])
    abstract fun provideMatchFragment(): MatchFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [MatchDetailModule::class])
    abstract fun provideMatchDetailActvity(): MatchDetailActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SearchEventModule::class])
    abstract fun provideSearchEvent(): SearchEventFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [SearchTeamModule::class])
    abstract fun provideSearchTeam(): SearchTeamFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [FavouriteTeamModule::class])
    abstract fun provideFavoriteTeam(): FavouriteTeamFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [FavouriteEventModule::class])
    abstract fun provideFavoriteEvent(): FavouriteEventFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [TeamDetailModule::class])
    abstract fun provideTeamDetailActivity(): TeamDetailActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [PlayerListModule::class])
    abstract fun providePlayerListFragment(): PlayerListFragment

}