package id.ilhamsuaib.kotlinmvp.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ilham on 10/12/17.
 */

@Module
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideAppContext(app: Application): Context = app.applicationContext
}