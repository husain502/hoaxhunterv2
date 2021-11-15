package com.example.hoaxhunterv2.Network

import com.example.hoaxhunterv2.BuildConfig
import com.example.hoaxhunterv2.database.remote.hoax.HoaxResponses
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @POST("antihoax")
    fun getallhoax(
            @Query("key") Key: String="43d93c474a0e06142a9a4c52484e6910")
    :Response<ArrayList<HoaxResponses>>

    @POST("antihoax")
    fun getdetailhoax(
        @Path("id") id:Int,
        @Query("key") Key: String="43d93c474a0e06142a9a4c52484e6910"

    )

    //43d93c474a0e06142a9a4c52484e6910
}