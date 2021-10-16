package com.example.hoaxhunterv2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [hoaxentity::class],version = 1)
abstract class databasehoax :RoomDatabase() {
    abstract  fun hoaxdao ():DaoHoax


    companion object {

        @Volatile
        private var INSTANCE : databasehoax?= null

        fun getInstance(context: Context) : databasehoax =
            INSTANCE ?: synchronized(this){
                Room.databaseBuilder(
                        context.applicationContext,
                        databasehoax::class.java,
                        "hoaxdatabase"
                        ).build().apply { INSTANCE = this }
            }
    }
}