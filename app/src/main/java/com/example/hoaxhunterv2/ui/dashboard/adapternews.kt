package com.example.hoaxhunterv2.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.hoaxhunterv2.Network.HoaxResponse
import com.example.hoaxhunterv2.R



var newsfilterlist = ArrayList<HoaxResponse>()
lateinit var mcontext: Context


class adapternews(private var listnews:ArrayList<HoaxResponse>): RecyclerView.Adapter<adapternews.adapternewsviewholder>(), Filterable{

    init {
        newsfilterlist=listnews
    }

    inner class adapternewsviewholder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): adapternewsviewholder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.news,viewGroup,false)
    }

    override fun onBindViewHolder(holder: adapternewsviewholder, position: Int) {
        val data:HoaxResponse = newsfilterlist[position]
        Glide.with(holder.itemView.context)
            .load(data.picture1)
            .apply(RequestOptions().override(250,250))
            .into(holder.Picture1)
        holder.



        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = newsfilterlist.size


    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }



}