package com.example.hoaxhunterv2.Network

import com.example.hoaxhunterv2.model.HoaxResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import java.util.*

interface Api {
    @GET("antihoax")
    @Headers("Authorization:43d93c474a0e06142a9a4c52484e6910")
    suspend fun getHoax(): Call<ArrayList<HoaxResponse>>
}