package com.example.hoaxhunterv2.Network

import com.example.hoaxhunterv2.BuildConfig
import com.example.hoaxhunterv2.Network.main.Hoax
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    //semua hoax
    @GET("antihoax")
    fun gethoax(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<Hoax>

}