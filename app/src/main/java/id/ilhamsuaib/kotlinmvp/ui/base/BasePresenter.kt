package id.ilhamsuaib.kotlinmvp.ui.base

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by ilham on 10/12/17.
 */
open class BasePresenter<T: BaseView> {

    protected val disposables = CompositeDisposable()
    protected var view: T? = null

    fun bind(view: T){
        this.view = view
    }

    fun unbind(){
        this.view = null
    }

    fun destroy(){
        disposables.clear()
        if (!disposables.isDisposed) disposables.dispose()
        unbind()
    }
}