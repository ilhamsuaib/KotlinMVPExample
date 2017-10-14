package id.ilhamsuaib.kotlinmvp.ui.main

import id.ilhamsuaib.kotlinmvp.data.model.Club
import id.ilhamsuaib.kotlinmvp.ui.base.BaseView

/**
 * Created by ilham on 10/13/17.
 */
interface MainView : BaseView{
    fun showMessage(s: String?)
    fun displayProvinsi(club: List<Club>)
}