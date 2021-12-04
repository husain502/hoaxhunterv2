package com.example.hoaxhunterv2.Detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hoaxhunterv2.Utilss.repository
import com.example.hoaxhunterv2.database.remote.hoax.detailhoax

class viewmodelhoaxdetail(private val repository: repository):ViewModel() {
    var id: Int = 0
    fun getdetailhoax(): LiveData<detailhoax> = repository.takehoaxdetail(id)
}