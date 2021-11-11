package com.example.hoaxhunterv2.database

import androidx.lifecycle.LiveData
import com.example.hoaxhunterv2.database.remote.hoax.detailhoax
import com.example.hoaxhunterv2.database.remote.modelhoax

interface hoaxresource{
    fun takehoaxlist(): LiveData<ArrayList<modelhoax>>

    fun takehoaxdetail(): LiveData<ArrayList<detailhoax>>
}
