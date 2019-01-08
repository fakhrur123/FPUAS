package app.tugas.finalproject.feature.favourite.event

import app.tugas.finalproject.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class FavouriteEventModule {

    @ActivityScope
    @Binds
    abstract fun provideFavoriteTeamFragment(favouriteEventFragment: FavouriteEventFragment): FavouriteEventContract.View

    @ActivityScope
    @Binds
    abstract fun provideFavoriteEventPresenter(favouriteEventPresenterImpl: FavouriteEventPresenterImpl): FavouriteEventContract.Presenter
}