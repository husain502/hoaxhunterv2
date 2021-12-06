package com.example.hoaxhunterv2.Utilss

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hoaxhunterv2.Detail.viewmodelhoaxdetail
import com.example.hoaxhunterv2.viewmodel.viewmodelhoax
import java.lang.IllegalArgumentException


@Suppress("UNCHECKED_CAST")
class Viewmodelfactory private constructor(private val repo: repository): ViewModelProvider.NewInstanceFactory() {


    override  fun <T: ViewModel?> create(modelClass: Class<T>): T{
        return when {
            modelClass.isAssignableFrom(viewmodelhoax::class.java)-> {
                viewmodelhoax(repo) as T
            }
            modelClass.isAssignableFrom(viewmodelhoaxdetail::class.java)-> {
                viewmodelhoaxdetail(repo)as T
            }
            else -> throw IllegalArgumentException("kelas tidak diketahui" +modelClass.name)


        }
    }
    companion object{
        @Volatile
        private var instance: Viewmodelfactory? = null

        fun getInstance():Viewmodelfactory =
            instance ?: synchronized(this){
                instance ?: Viewmodelfactory(Injection.provideRepository()).apply {
                    instance = this
                }
            }
    }
}