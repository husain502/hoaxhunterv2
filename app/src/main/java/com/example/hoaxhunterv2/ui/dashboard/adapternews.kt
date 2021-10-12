package com.example.hoaxhunterv2.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hoaxhunterv2.Network.HoaxResponse
import com.example.hoaxhunterv2.R

class adapternews(private val listnews: ArrayList<HoaxResponse>): RecyclerView.Adapter<adapternews.adapternewsviewholder>(){


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): adapternewsviewholder {
      val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.news,viewGroup,false)
        return adapternewsviewholder(view)
    }

    override fun onBindViewHolder(holder: adapternewsviewholder, position: Int) {
        val (picture1,tanggal,judul,fact,typehoaks) = listnews[position]
        holder.Picture1.setImageResource(picture1)

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
    class adapternewsviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}