package id.ilhamsuaib.kotlinmvp.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by ilham on 10/12/17.
 */

@Module
class AppModule {

    @Provides
    fun provideAppContext(app: Application): Context = app.applicationContext
}