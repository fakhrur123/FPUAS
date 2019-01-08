package app.tugas.finalproject.repository

import android.app.Application
import app.tugas.finalproject.di.scope.ApplicationContext
import app.tugas.finalproject.di.scope.ApplicationScope
import app.tugas.finalproject.helper.database
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @ApplicationScope
    @Provides
    internal fun provideDatabaseHelper(@ApplicationContext application: Application): DatabaseUtils {
        return application.database
    }

    @ApplicationScope
    @Provides
    internal fun provideFavoriteEventRepository(databaseUtils: DatabaseUtils): FavouriteMatchRepository {
        return FavouriteMatchRepositoryImpl(databaseUtils)
    }

    @ApplicationScope
    @Provides
    internal fun provideFavoriteTeamRepository(databaseUtils: DatabaseUtils): FavoriteTeamRepository {
        return FavoriteTeamRepositoryImpl(databaseUtils)
    }
}