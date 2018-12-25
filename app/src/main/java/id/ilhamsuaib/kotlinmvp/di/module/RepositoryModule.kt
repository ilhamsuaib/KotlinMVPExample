package id.ilhamsuaib.kotlinmvp.di.module

import dagger.Module
import dagger.Provides
import id.ilhamsuaib.kotlinmvp.data.repository.ClubRepository
import id.ilhamsuaib.kotlinmvp.data.repository.ClubRepositoryImpl
import javax.inject.Singleton

/**
 * Created by @ilhamsuaib on 7/21/18.
 * github.com/ilhamsuaib
 */

@Module
object RepositoryModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideRepository(repositoryImpl: ClubRepositoryImpl): ClubRepository = repositoryImpl
}