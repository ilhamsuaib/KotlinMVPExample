package id.ilhamsuaib.kotlinmvp.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import id.ilhamsuaib.kotlinmvp.BuildConfig
import id.ilhamsuaib.kotlinmvp.data.ApiService
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by @ilhamsuaib on 7/20/18.
 * github.com/ilhamsuaib
 */

@Module
class NetworkModule {

    companion object {
        const val DEFAULT_TIMEOUT = 30L
        const val CACHE_CONTROL_HEADER = "Cache-Control"
    }

    @Provides
    fun provideOkHttpClient(app: Application): OkHttpClient {

        val context: Context = app.applicationContext

        val cacheControl = CacheControl.Builder()
                .maxAge(10, TimeUnit.DAYS)
                .build()

        val cache = Cache(File(context.cacheDir, "cache"), 10 * 1024 * 1024)

        return OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .addNetworkInterceptor { chain ->
                    chain.proceed(chain.request())
                            .newBuilder()
                            .header(CACHE_CONTROL_HEADER, cacheControl.toString())
                            .build()
                }
                .addInterceptor { chain ->
                    val request = chain.request()
                            .newBuilder()
                            .cacheControl(cacheControl)
                            .build()
                    return@addInterceptor chain.proceed(request)
                }
                .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : ApiService = retrofit.create(ApiService::class.java)
}