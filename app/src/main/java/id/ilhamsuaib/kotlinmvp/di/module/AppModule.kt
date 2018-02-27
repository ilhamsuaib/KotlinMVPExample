package id.ilhamsuaib.kotlinmvp.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import id.ilhamsuaib.kotlinmvp.BuildConfig
import id.ilhamsuaib.kotlinmvp.data.ApiService
import id.ilhamsuaib.kotlinmvp.di.scope.ApplicationContext
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by ilham on 10/12/17.
 */

@Module
class AppModule(private val app: Application) {

    @Provides
    fun provideApplication() : Application = app

    @Provides
    @ApplicationContext
    fun provideAppContext() : Context = app

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor  = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttp = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)

        return okHttp.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)

        return retrofit.build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : ApiService = retrofit.create(ApiService::class.java)
}