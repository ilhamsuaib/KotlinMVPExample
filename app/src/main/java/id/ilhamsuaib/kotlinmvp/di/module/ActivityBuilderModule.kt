package id.ilhamsuaib.kotlinmvp.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.ilhamsuaib.kotlinmvp.presentation.ui.main.MainActivity

/**
 * Created by @ilhamsuaib on 7/20/18.
 * github.com/ilhamsuaib
 */

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}