package id.ilhamsuaib.kotlinmvp.di.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import id.ilhamsuaib.kotlinmvp.di.scope.ActivityContext
import id.ilhamsuaib.kotlinmvp.di.scope.ActivityScope

/**
 * Created by ilham on 10/12/17.
 */
@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @ActivityScope
    fun provideActivity() : Activity = activity

    @Provides
    @ActivityContext
    fun provideActivityContext() : Context = activity
}