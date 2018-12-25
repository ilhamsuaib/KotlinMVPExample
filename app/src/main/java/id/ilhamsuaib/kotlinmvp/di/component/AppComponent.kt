package id.ilhamsuaib.kotlinmvp.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import id.ilhamsuaib.kotlinmvp.BaseApp
import id.ilhamsuaib.kotlinmvp.di.module.ActivityBuilderModule
import id.ilhamsuaib.kotlinmvp.di.module.AppModule
import id.ilhamsuaib.kotlinmvp.di.module.NetworkModule
import id.ilhamsuaib.kotlinmvp.di.module.RepositoryModule
import javax.inject.Singleton

/**
 * Created by ilham on 10/12/17.
 */

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    ActivityBuilderModule::class,
    RepositoryModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(baseApp: BaseApp)
}