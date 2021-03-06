package id.ilhamsuaib.kotlinmvp.presentation.ui.main

import id.ilhamsuaib.kotlinmvp.data.repository.ClubRepository
import id.ilhamsuaib.kotlinmvp.presentation.base.BasePresenter
import id.ilhamsuaib.kotlinmvp.utilities.logD
import id.ilhamsuaib.kotlinmvp.utilities.toJsonElement
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by ilham on 10/13/17.
 */

class MainPresenter @Inject constructor(private val clubRepository: ClubRepository): BasePresenter<MainView>() {

    private val tag = "MainPresenter"

    fun getClubs(){
        view?.showProgress(true)
        disposables.add(
                clubRepository.getClubs()
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnComplete { view?.showProgress(false) }
                        .subscribe({
                            logD(tag, "club list : ${toJsonElement(it)}")
                            view?.displayClub(it)
                        }, Throwable::printStackTrace)
        )
    }
}