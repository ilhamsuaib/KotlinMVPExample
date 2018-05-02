package id.ilhamsuaib.kotlinmvp.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by ilham on 2/27/18.
 */

@Parcelize
data class Club(var key: String? = "", var name: String? = "", var code: String? = ""): Parcelable