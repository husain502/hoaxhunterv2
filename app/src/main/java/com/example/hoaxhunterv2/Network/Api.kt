package com.example.hoaxhunterv2.Network

import com.example.hoaxhunterv2.BuildConfig
import com.example.hoaxhunterv2.database.remote.hoax.HoaxResponses
import com.example.hoaxhunterv2.database.remote.hoax.detailhoax
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @GET("antihoax")
    fun getallhoax(
            @Query("")Key: String=BuildConfig.API_KEY)
    : Call<HoaxResponses>

    @GET("antihoax")
    fun getdetailhoax(
        @Path("id") id:Int,
        @Query("key") Key: String=BuildConfig.API_KEY)
    :Call<detailhoax>

    //43d93c474a0e06142a9a4c52484e6910
}