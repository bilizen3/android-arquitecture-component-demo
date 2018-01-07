package com.spidev.android_arquitecture_component_demo.repository.remote.api

import com.spidev.android_arquitecture_component_demo.util.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by carlos on 1/7/18.
 */
object WebServiceApiManager {

    private var webServiceApi: WebServiceApi? = null

    fun apiManager(): WebServiceApi {
        if (webServiceApi == null) {
            val logging = HttpLoggingInterceptor();
            logging.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build()

            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            webServiceApi = retrofit.create(WebServiceApi::class.java)
        }
        return webServiceApi!!
    }
}