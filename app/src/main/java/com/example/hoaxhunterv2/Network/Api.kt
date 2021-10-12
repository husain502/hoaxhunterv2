package com.example.hoaxhunterv2.Network

import retrofit2.Call
import retrofit2.http.GET
import java.util.*

interface Api {
    @GET("antihoax")
    fun getHoax(): Call<ArrayList<HoaxResponse>>
}