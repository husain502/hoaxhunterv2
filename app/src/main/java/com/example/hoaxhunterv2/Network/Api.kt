package com.example.hoaxhunterv2.Network

import com.example.hoaxhunterv2.BuildConfig
import com.example.hoaxhunterv2.data.Hoax
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @FormUrlEncoded
    @POST("antihoax")
    fun getallhoax(@Query("43d93c474a0e06142a9a4c52484e6910") Key:String)
    :Response<ArrayList<Hoax>>

}