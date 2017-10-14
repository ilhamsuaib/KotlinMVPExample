package id.ilhamsuaib.kotlinmvp.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by ilham on 10/13/17.
 */
@Parcelize
data class Response(@SerializedName("name")
                    @Expose
                    val error: String? = null,
                    @SerializedName("clubs")
                    @Expose
                    val clubs: List<Club>? = null) : Parcelable

@Parcelize
data class Club(@SerializedName("key")
                @Expose
                val key: String? = null,
                @SerializedName("name")
                @Expose
                val name: String? = null,
                @SerializedName("code")
                @Expose
                val code: String? = null) : Parcelable