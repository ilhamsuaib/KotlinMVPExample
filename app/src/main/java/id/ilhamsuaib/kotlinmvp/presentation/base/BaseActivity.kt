package id.ilhamsuaib.kotlinmvp.presentation.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.ilhamsuaib.kotlinmvp.BaseApp
import id.ilhamsuaib.kotlinmvp.di.component.ActivityComponent
import id.ilhamsuaib.kotlinmvp.di.module.ActivityModule

/**
 * Created by ilham on 10/12/17.
 */

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityComponent = (application as BaseApp)
                .appComponent
                .activityComponent()
                .activityModule(ActivityModule(this))
                .build()

        injectModule(activityComponent)
    }

    abstract fun injectModule(activityComponent: ActivityComponent)
}