package com.matheussilas97.data

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Apifactory {

    private const val URL_VIA_CEP = "viacep.com.br/ws/"

    private val authInterceptor = Interceptor { chain ->

        val newUrl = chain.request().url()
            .newBuilder()
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .header("Content-Type", "application/json")
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    private val apiClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()


    private fun retrofit(): Retrofit = Retrofit.Builder()
        .client(apiClient)
        .baseUrl(URL_VIA_CEP)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T {
        return retrofit().create(serviceClass)
    }
}


