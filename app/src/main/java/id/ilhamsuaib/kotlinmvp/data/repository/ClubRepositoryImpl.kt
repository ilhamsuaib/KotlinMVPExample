package id.ilhamsuaib.kotlinmvp.data.repository

import id.ilhamsuaib.kotlinmvp.data.ApiService
import id.ilhamsuaib.kotlinmvp.presentation.model.Club
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by @ilhamsuaib on 7/21/18.
 * github.com/ilhamsuaib
 */

class ClubRepositoryImpl @Inject constructor(private val service: ApiService): ClubRepository {

    override fun getClubs(): Flowable<List<Club>> {
        return service.getClubs()
                .flatMap { Flowable.fromIterable(it.clubs) }
                .map { it.transform() }
                .toList()
                .toFlowable()
    }
}