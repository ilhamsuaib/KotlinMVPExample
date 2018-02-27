package id.ilhamsuaib.kotlinmvp.data

import id.ilhamsuaib.kotlinmvp.data.model.Response
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Created by ilham on 10/13/17.
 */

interface ApiService {

    @GET("opendatajson/football.json/master/2017-18/es.1.clubs.json")
    fun getClubs() : Flowable<Response>
}