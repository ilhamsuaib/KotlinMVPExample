package id.ilhamsuaib.kotlinmvp.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import id.ilhamsuaib.kotlinmvp.R
import id.ilhamsuaib.kotlinmvp.data.model.Club
import id.ilhamsuaib.kotlinmvp.di.component.ActivityComponent
import id.ilhamsuaib.kotlinmvp.ui.base.BaseActivity
import id.ilhamsuaib.kotlinmvp.ui.main.adapter.ClubAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import id.ilhamsuaib.kotlinmvp.utilities.TAG

/**
 * Created by ilham on 10/12/17.
 */
class MainActivity : BaseActivity(), MainView {

    val TAG = TAG(MainActivity::class.java)

    @Inject
    lateinit var presenter: MainPresenter
    @Inject
    lateinit var clubAdapter: ClubAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.bind(this)

        recClub.layoutManager = LinearLayoutManager(this)
        recClub.adapter = clubAdapter

        presenter.getClubs()
    }

    override fun injectModule(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun showProgress(show: Boolean) {
        runOnUiThread { progressBar.visibility = if (show) View.VISIBLE else View.GONE }
    }

    override fun showMessage(s: String?) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    override fun displayClub(club: List<Club>) {
        Log.d(TAG, "club list ${Gson().toJsonTree(club)}")
        clubAdapter.clearItem()
        clubAdapter.addItems(club)
    }
}