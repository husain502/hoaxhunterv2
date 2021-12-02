package com.example.hoaxhunterv2.Utilss

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hoaxhunterv2.database.hoaxresource
import com.example.hoaxhunterv2.database.remote.hoax.detailhoax
import com.example.hoaxhunterv2.database.remote.modelhoax
import com.example.hoaxhunterv2.database.remotedatasource

class repository private constructor(private val RemoteDataSource: remotedatasource):hoaxresource{
    override fun takehoaxlist(): LiveData<ArrayList<modelhoax>> {
        val listhoax = MutableLiveData<ArrayList<modelhoax>>()
        RemoteDataSource.getlisthoax(object:remotedatasource.LoadListhoaxcallback{
            override fun onLoadHoax(response: ArrayList<modelhoax>) {
                val hoaxlist = ArrayList<modelhoax>()
                if (response != null){
                    for (HoaxResponse: modelhoax in response){
                        val hoax = modelhoax(
                            id = HoaxResponse.id,
                            title = HoaxResponse.title,
                            picture1 = HoaxResponse.picture1,
                            date = HoaxResponse.date,
                        classification = HoaxResponse.classification)
                        hoaxlist.add(hoax)
                    }
                    listhoax.postValue(hoaxlist)
                }
            }
        })
        return listhoax
    }


    override fun takehoaxdetail(id:Int): LiveData<detailhoax> {
       val HoaxDetail = MutableLiveData<detailhoax>()
        RemoteDataSource.getdetailHoax(object: remotedatasource.LoadHoaxDetail{
            override fun onLoadDetailHoax(response: detailhoax?) {
                if (response != null) {
                    val hoax = detailhoax(
                        id = response.id,
                        title = response.title,
                        classification = response.classification,
                        content = response.content,
                        picture1 = response.picture1,
                        reference = response.reference,
                        fact = response.fact,
                        date = response.date
                    )
                    HoaxDetail.postValue(hoax)
                }
            }
        },id)
        return HoaxDetail
    }
    companion object{
        private var instance: repository? = null
        fun getInstance(RemoteDataSource: remotedatasource): repository =
                instance ?: synchronized (this){
                    instance ?: repository(RemoteDataSource).apply { instance =this}
                }
    }


}