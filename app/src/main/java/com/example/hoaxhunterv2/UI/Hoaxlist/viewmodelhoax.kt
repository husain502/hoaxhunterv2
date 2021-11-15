package com.example.hoaxhunterv2.UI.Hoaxlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hoaxhunterv2.Utilss.repository
import com.example.hoaxhunterv2.database.remote.modelhoax

class viewmodelhoax(private val repository: repository):ViewModel() {
    fun takehoaxdata(): LiveData<ArrayList<modelhoax>> =repository.takehoaxlist()
}