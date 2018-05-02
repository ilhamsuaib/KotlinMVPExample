package id.ilhamsuaib.kotlinmvp.data.repository

import id.ilhamsuaib.kotlinmvp.data.ApiService
import id.ilhamsuaib.kotlinmvp.presentation.model.Club
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ilham on 10/13/17.
 */

@Singleton
class ClubRepositoryImpl @Inject constructor(private val service: ApiService) : ClubRepository {

    override fun getClubs(): Flowable<List<Club>> {
        return service.getClubs()
                .flatMap { Flowable.fromIterable(it.clubs) }
                .map { it.transform() }
                .toList()
                .toFlowable()
    }
}