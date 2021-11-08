package com.example.hoaxhunterv2.Network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiConfig {
    companion object{
        fun getApiService(): Api{
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://yudistira.turnbackhoax.id/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            val apiInstance: Api = retrofit.create((Api::class.java))
            return retrofit.create(Api::class.java)

        }
    }
}