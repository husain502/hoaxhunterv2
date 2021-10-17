package com.example.hoaxhunterv2.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.hoaxhunterv2.model.HoaxResponse
import com.example.hoaxhunterv2.R




class adapternews(private var listnews:ArrayList<HoaxResponse>): RecyclerView.Adapter<adapternews.adapternewsviewholder>(){

    inner class adapternewsviewholder (itemView: View) : RecyclerView.ViewHolder(itemView){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapternewsviewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news,parent,false)
        return adapternewsviewholder(view)
    }

    override fun onBindViewHolder(holder: adapternewsviewholder, position: Int) {

    }

    override fun getItemCount(): Int {

    }
}