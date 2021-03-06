package com.example.hoaxhunterv2.database.remote.hoax

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiConfig {

    private val retrofit = Retrofit.Builder()
                .baseUrl("https://yudistira.turnbackhoax.id/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    val apiInstance: Api = retrofit.create(Api::class.java)
        }
