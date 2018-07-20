package id.ilhamsuaib.kotlinmvp.di.component

import android.app.Application
import dagger.BindsInstance
import id.ilhamsuaib.kotlinmvp.di.module.AppModule
import dagger.Component
import id.ilhamsuaib.kotlinmvp.BaseApp
import id.ilhamsuaib.kotlinmvp.di.module.ActivityBuilderModule
import id.ilhamsuaib.kotlinmvp.di.module.NetworkModule
import id.ilhamsuaib.kotlinmvp.di.module.RepositoryModule
import javax.inject.Singleton

/**
 * Created by ilham on 10/12/17.
 */

@Singleton
@Component(modules = [
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