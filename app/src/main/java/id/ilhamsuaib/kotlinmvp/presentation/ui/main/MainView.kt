package id.ilhamsuaib.kotlinmvp.presentation.ui.main

import id.ilhamsuaib.kotlinmvp.presentation.base.BaseView
import id.ilhamsuaib.kotlinmvp.presentation.model.Club

/**
 * Created by ilham on 10/13/17.
 */

interface MainView : BaseView {

    fun showProgress(show: Boolean)

    fun showMessage(s: String?)

    fun displayClub(club: List<Club>)
}