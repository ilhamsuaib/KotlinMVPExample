package id.ilhamsuaib.kotlinmvp.di.component

import id.ilhamsuaib.kotlinmvp.di.module.AppModule
import dagger.Component
import id.ilhamsuaib.kotlinmvp.di.module.DataModule
import javax.inject.Singleton

/**
 * Created by ilham on 10/12/17.
 */

@Singleton
@Component(modules = [AppModule::class, DataModule::class])
interface AppComponent {

    fun activityComponent(): ActivityComponent.Builder
}