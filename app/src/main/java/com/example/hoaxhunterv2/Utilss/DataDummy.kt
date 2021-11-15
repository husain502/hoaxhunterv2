package com.example.hoaxhunterv2.Utilss

import android.util.Log
import com.example.hoaxhunterv2.database.remote.hoax.HoaxResponses
import com.example.hoaxhunterv2.database.remote.hoax.detailhoax
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream


object DataDummy {
    private var data = Gson()

    fun getdummyhoac() = data.fromJson(loadJSON("hoaxlist.json"),HoaxResponses::class.java).results
    fun getdummydetailhoax()=data.fromJson(loadJSON("hoaxdetail.json"),detailhoax::class.java)


    private fun loadJSON(filename: String): String?{
        var json: String? = null
        try {
            val input : InputStream = this.javaClass.classLoader!!.getResourceAsStream(filename)
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            json = String(buffer, charset("UTF-8"))
        }catch (ex: IOException){
            Log.e("Dummy", ex.toString())
        }

        return json
    }
}