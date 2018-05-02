package id.ilhamsuaib.kotlinmvp

import android.app.Application
import android.content.Context
import id.ilhamsuaib.kotlinmvp.di.component.AppComponent
import id.ilhamsuaib.kotlinmvp.di.component.DaggerAppComponent
import id.ilhamsuaib.kotlinmvp.di.module.AppModule

/**
 * Created by ilham on 10/12/17.
 */

class BaseApp : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}