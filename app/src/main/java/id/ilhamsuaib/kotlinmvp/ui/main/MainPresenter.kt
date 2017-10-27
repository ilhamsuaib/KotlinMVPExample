package id.ilhamsuaib.kotlinmvp.ui.main

import id.ilhamsuaib.kotlinmvp.data.repository.ClubRepository
import id.ilhamsuaib.kotlinmvp.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by ilham on 10/13/17.
 */
class MainPresenter @Inject constructor(private val clubRepository: ClubRepository) : BasePresenter<MainView>(){

    fun getClubs(){
        view?.showProgress(true)
        disposables.add(clubRepository.getClubs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach { view?.showProgress(false) }
                .subscribe({ view?.displayClub(it) }, { it.printStackTrace()}))
    }
}