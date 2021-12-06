package com.example.hoaxhunterv2.database

import android.util.Log
import com.example.hoaxhunterv2.database.remote.hoax.ApiConfig
import com.example.hoaxhunterv2.database.remote.hoax.ApiConfig.apiInstance
import com.example.hoaxhunterv2.Utilss.IdlingResource.increment
import com.example.hoaxhunterv2.database.remote.hoax.HoaxResponses
import com.example.hoaxhunterv2.database.remote.hoax.detailhoax
import com.example.hoaxhunterv2.database.remote.modelhoax
import retrofit2.Call
import retrofit2.Response

class remotedatasource {

    companion object{
        private const val SERVICE_LATENCY_IN_MILLIS:Long=2000
        const val SUCCES = "succes"
        const val FAIL = "fail"


        @Volatile
        private var instance: remotedatasource? = null

        fun getInstance(): remotedatasource =
                instance ?: synchronized(this){
                    instance ?: remotedatasource()
                }
    }


    fun getlisthoax(callback:LoadListhoaxcallback){
        com.example.hoaxhunterv2.Utilss.IdlingResource.increment()
        ApiConfig.apiInstance
                .getallhoax()
                .enqueue (object : retrofit2.Callback<List<modelhoax>>{
                    override fun onFailure(call: Call<List<modelhoax>>, t: Throwable) {
                        Log.d(FAIL, t.message.toString())
                        com.example.hoaxhunterv2.Utilss.IdlingResource.decrement()}
                    override fun onResponse(call: Call<List<modelhoax>>, response: Response<List<modelhoax>>) {

                    }
                })
    }
    fun getdetailHoax(callback: LoadHoaxDetail, id:Int){
        increment()
        apiInstance
                .getdetailhoax(id)
                .enqueue(object: retrofit2.Callback<detailhoax>{
                    override fun onFailure(call: Call<detailhoax>, t: Throwable) {
                        Log.d(FAIL, t.message.toString())
                        com.example.hoaxhunterv2.Utilss.IdlingResource.decrement()
                    }

                    override fun onResponse(
                        call: Call<detailhoax>,
                        response: Response<detailhoax>
                    ) {
                        callback.onLoadDetailHoax(response.body())
                        Log.d(SUCCES,response.code().toString())
                        com.example.hoaxhunterv2.Utilss.IdlingResource.decrement()
                    }
                })
    }




    interface LoadListhoaxcallback{
        fun onLoadHoax(response:ArrayList<modelhoax>)
    }
    interface LoadHoaxDetail{
        fun onLoadDetailHoax(response:detailhoax?)
    }
}