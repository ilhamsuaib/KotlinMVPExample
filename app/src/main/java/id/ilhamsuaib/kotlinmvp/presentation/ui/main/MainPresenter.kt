package id.ilhamsuaib.kotlinmvp.presentation.ui.main

import id.ilhamsuaib.kotlinmvp.data.repository.ClubRepository
import id.ilhamsuaib.kotlinmvp.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by ilham on 10/13/17.
 */

class MainPresenter @Inject constructor(private val clubRepository: ClubRepository) : BasePresenter<MainView>(){

    fun getClubs(){
        view?.showProgress(true)
        disposables.add(
                clubRepository.getClubs()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete { view?.showProgress(false) }
                .subscribe(
                        {
                            view?.displayClub(it)
                        },
                        {
                            it.printStackTrace()
                        }
                )
        )
    }
}