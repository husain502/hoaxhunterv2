package com.example.hoaxhunterv2.database.remote.hoax

import com.example.hoaxhunterv2.BuildConfig
import com.example.hoaxhunterv2.database.remote.hoax.HoaxResponses
import com.example.hoaxhunterv2.database.remote.hoax.detailhoax
import com.example.hoaxhunterv2.database.remote.modelhoax
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Api {
    @FormUrlEncoded
    @POST("antihoax")
    fun getallhoax(
            @Field("")Key: String=BuildConfig.API_KEY)
    : Response<List<modelhoax>>

    @GET("antihoax")
    fun getdetailhoax(
        @Path("id") id:Int,
        @Query("key") Key: String=BuildConfig.API_KEY)
    :Call<detailhoax>

    //43d93c474a0e06142a9a4c52484e6910
}