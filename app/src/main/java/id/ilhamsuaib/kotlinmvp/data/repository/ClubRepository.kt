package id.ilhamsuaib.kotlinmvp.data.repository

import id.ilhamsuaib.kotlinmvp.data.ApiService
import id.ilhamsuaib.kotlinmvp.presentation.model.Club
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by ilham on 10/13/17.
 */

interface ClubRepository {
    fun getClubs(): Flowable<List<Club>>
}