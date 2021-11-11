package com.example.hoaxhunterv2.Network

import retrofit2.Response
import retrofit2.http.*

interface Api {

    @POST("antihoax")
    fun getallhoax(@Query("43d93c474a0e06142a9a4c52484e6910") Key: String.Companion)
    :Response<ArrayList<Hoax>>

}