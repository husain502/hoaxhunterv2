package com.example.hoaxhunterv2.Utilss

object Injection {


    fun provideRepository(): allrepository{
        val dataSource = remoteDataSource.getInstance()

        return  allrepository.getInstance(dataSource)
    }
}