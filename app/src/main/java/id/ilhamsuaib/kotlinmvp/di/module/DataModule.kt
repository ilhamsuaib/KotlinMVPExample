package id.ilhamsuaib.kotlinmvp.di.module

import dagger.Binds
import dagger.Module
import id.ilhamsuaib.kotlinmvp.data.repository.ClubRepository
import id.ilhamsuaib.kotlinmvp.data.repository.ClubRepositoryImpl

/**
 * Created by ilham on 10/13/17.
 */
@Module
abstract class DataModule() {

    @Binds
    internal abstract fun provideClubManager(clubManagerImpl: ClubRepositoryImpl) : ClubRepository
}