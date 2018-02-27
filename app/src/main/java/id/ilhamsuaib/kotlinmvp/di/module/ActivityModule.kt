package id.ilhamsuaib.kotlinmvp.di.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import id.ilhamsuaib.kotlinmvp.di.scope.ActivityContext
import id.ilhamsuaib.kotlinmvp.di.scope.PerActivity
import javax.inject.Singleton

/**
 * Created by ilham on 10/12/17.
 */
@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @PerActivity
    fun provideActivity() : Activity = activity

    @Provides
    @ActivityContext
    fun provideActivityContex() : Context = activity
}