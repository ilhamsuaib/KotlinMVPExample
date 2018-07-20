package id.ilhamsuaib.kotlinmvp.presentation.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import dagger.android.AndroidInjection
import id.ilhamsuaib.kotlinmvp.R
import id.ilhamsuaib.kotlinmvp.presentation.model.Club
import id.ilhamsuaib.kotlinmvp.presentation.ui.main.adapter.ClubAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Created by ilham on 10/12/17.
 */

class MainActivity : AppCompatActivity(), MainView {

    private val tag = "MainActivity"

    @Inject
    lateinit var presenter: MainPresenter
    @Inject
    lateinit var clubAdapter: ClubAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.bind(this)

        setupView()
    }

    private fun setupView() {
        recClub.layoutManager = LinearLayoutManager(this)
        recClub.adapter = clubAdapter
        presenter.getClubs()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun showProgress(show: Boolean) {
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showMessage(s: String?) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    override fun displayClub(club: List<Club>) {
        Log.d(tag, "club list ${Gson().toJsonTree(club)}")
        clubAdapter.clearItem()
        clubAdapter.addItems(club)
    }
}