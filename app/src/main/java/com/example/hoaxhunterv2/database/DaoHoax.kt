package com.example.hoaxhunterv2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface DaoHoax {

    @Query("SELECT *FROM hoax ORDER BY tanggal ASC")
    fun readAllhoax(): LiveData<List<hoaxentity>>


    @Update
    fun update(hoax: DaoHoax)

    /* @Query("SELECT * FROM hoax WHERE title LIKE")
    fun findBytitle(title:String):hoaxentity*/

}