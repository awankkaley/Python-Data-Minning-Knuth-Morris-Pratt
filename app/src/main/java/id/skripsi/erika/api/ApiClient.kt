package id.co.pcsindonesia.ia.pos.api

import android.content.Context
import id.skripsi.erika.UserPreference
import id.skripsi.erika.api.ApiInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient() {
    private lateinit var preference: UserPreference

    private var httpLoggingInterceptor = HttpLoggingInterceptor()


    fun create(context: Context?): ApiInterface {
        preference = UserPreference(context)
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY;
        val BASE_URL = "http://45.13.132.247:5004"
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(1000, TimeUnit.SECONDS)
            .writeTimeout(1000, TimeUnit.SECONDS)
            .connectTimeout(1000, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .retryOnConnectionFailure(true)
            .build()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
        return retrofit.create(ApiInterface::class.java)
    }
}