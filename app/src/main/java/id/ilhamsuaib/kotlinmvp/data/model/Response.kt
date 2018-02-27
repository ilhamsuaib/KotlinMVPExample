package id.ilhamsuaib.kotlinmvp.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by ilham on 10/13/17.
 */

data class Response(

        @field:SerializedName("name")
        val error: String? = "",

        @field:SerializedName("clubs")
        val clubs: List<ClubModel>? = null)