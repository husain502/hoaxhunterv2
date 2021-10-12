package com.example.hoaxhunterv2.Network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Client {
   private const val BASE_URL = "https://yudistira.turnbackhoax.id/api"

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    retrofit.create(Api::class.java)
    }
}
