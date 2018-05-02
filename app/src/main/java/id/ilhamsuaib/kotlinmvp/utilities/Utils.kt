package id.ilhamsuaib.kotlinmvp.utilities

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonElement
import id.ilhamsuaib.kotlinmvp.BuildConfig

/**
 * Created by ilham on 10/13/17.
 */

fun logI(tag: String, msg: String) {
    if (BuildConfig.DEBUG) Log.i(tag, msg)
}

fun logW(tag: String, msg: String) {
    if (BuildConfig.DEBUG) Log.w(tag, msg)
}

fun logE(tag: String, msg: String) {
    if (BuildConfig.DEBUG) Log.e(tag, msg)
}

fun logD(tag: String, msg: String) {
    if (BuildConfig.DEBUG) Log.d(tag, msg)
}

fun toJsonElement(any: Any): JsonElement = Gson().toJsonTree(any)