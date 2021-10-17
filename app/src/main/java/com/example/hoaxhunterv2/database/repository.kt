package com.example.hoaxhunterv2.database

import androidx.lifecycle.LiveData
import com.example.hoaxhunterv2.model.HoaxResponse

class repository(private val daoHoax: DaoHoax) {

    val readallhoax: LiveData<List<hoaxentity>> = daoHoax.readAllhoax()

    //outside of room

    suspend fun getallhoax(): HoaxResponse {
        return
    }


    fun update(hoax: DaoHoax){
        daoHoax.update(hoax)
    }
}