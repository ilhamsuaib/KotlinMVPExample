package id.ilhamsuaib.kotlinmvp.data.model

import com.google.gson.annotations.SerializedName
import id.ilhamsuaib.kotlinmvp.presentation.model.Club

/**
 * Created by ilham on 2/27/18.
 */

data class ClubModel(

        @field:SerializedName("key")
        private val key: String? = "",

        @field:SerializedName("name")
        private val name: String? = "",

        @field:SerializedName("code")
        private val code: String? = "") {

        fun toViewModel(): Club = Club(key = this.key, name = this.name, code = this.code)
}