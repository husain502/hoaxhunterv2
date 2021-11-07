package com.example.hoaxhunterv2.Network.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hoaxhunterv2.R

class mainadapter (private val list: ArrayList<HoaxResponse>):RecyclerView.Adapter<mainadapter.mainviewholder>(){
    inner class mainviewholder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(hoaxResponse: HoaxResponse){
            with(itemView){
                val text: Int = "id: ${HoaxResponse.id}\n " +

            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mainviewholder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news,parent,false)
        return mainviewholder(view)
    }

    override fun onBindViewHolder(holder: mainadapter.mainviewholder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int =list.size
    }


}