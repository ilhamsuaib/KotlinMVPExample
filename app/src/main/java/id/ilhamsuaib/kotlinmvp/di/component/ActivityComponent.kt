package id.ilhamsuaib.kotlinmvp.di.component

import dagger.Component
import dagger.Subcomponent
import id.ilhamsuaib.kotlinmvp.di.module.ActivityModule
import id.ilhamsuaib.kotlinmvp.di.scope.PerActivity
import id.ilhamsuaib.kotlinmvp.ui.main.MainActivity
import javax.inject.Singleton

/**
 * Created by ilham on 10/12/17.
 */
@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    @Subcomponent.Builder
    interface Builder {
        fun activityModule(activityModule: ActivityModule): Builder

        fun build(): ActivityComponent
    }

    fun inject(activityMain: MainActivity)
}