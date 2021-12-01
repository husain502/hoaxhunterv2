package com.example.hoaxhunterv2.Network

import com.example.hoaxhunterv2.BuildConfig
import com.example.hoaxhunterv2.database.remote.hoax.HoaxResponses
import com.example.hoaxhunterv2.database.remote.hoax.detailhoax
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @POST("antihoax")
    fun getallhoax(
            @Query("key") Key: String="43d93c474a0e06142a9a4c52484e6910")
    : Call<HoaxResponses>

    @POST("antihoax")
    fun getdetailhoax(
        @Path("id") id:Int,
        @Query("key") Key: String="43d93c474a0e06142a9a4c52484e6910")
    :Call<detailhoax>

    //43d93c474a0e06142a9a4c52484e6910
}