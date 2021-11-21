package com.example.hoaxhunterv2.Utilss

import com.example.hoaxhunterv2.database.remotedatasource

object Injection {


    fun provideRepository(): repository{
        val dataSource = remotedatasource.getInstance()

        return  repository.getInstance(dataSource)
    }
}