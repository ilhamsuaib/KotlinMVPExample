package id.ilhamsuaib.kotlinmvp.di.module

import dagger.Module
import dagger.Provides
import id.ilhamsuaib.kotlinmvp.data.repository.ClubRepository
import id.ilhamsuaib.kotlinmvp.data.repository.ClubRepositoryImpl
import javax.inject.Singleton

/**
 * Created by ilham on 10/13/17.
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideClubManager(clubManagerImpl: ClubRepositoryImpl) : ClubRepository = clubManagerImpl
}