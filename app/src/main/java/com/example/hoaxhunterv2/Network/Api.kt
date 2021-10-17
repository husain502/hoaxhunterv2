package com.example.hoaxhunterv2.Network

import com.example.hoaxhunterv2.model.HoaxResponse
import retrofit2.Call
import retrofit2.http.GET
import java.util.*

interface Api {
    @GET("antihoax")
    suspend fun getHoax(): Call<ArrayList<HoaxResponse>>
}