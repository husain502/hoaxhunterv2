package com.example.hoaxhunterv2.UI.Hoaxlist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hoaxhunterv2.Utilss.onItemclickhoax
import com.example.hoaxhunterv2.database.remote.modelhoax
import com.example.hoaxhunterv2.databinding.NewsBinding

class hoaxadapter : RecyclerView.Adapter<hoaxadapter.ViewHolder>(){
    private val listhoax = ArrayList<modelhoax>()

    fun setHoax(hoax: List<modelhoax>?){
        if (hoax == null)return
        this.listhoax.clear()
        this.listhoax.addAll(hoax)
        notifyDataSetChanged()
        Log.d("",listhoax.toString())
    }



    inner class ViewHolder(private val binding: NewsBinding):RecyclerView.ViewHolder(binding.root) {
        fun bindhoax(hoax: modelhoax){
            with(binding){
                title.text = hoax.title
                typehoaks.text = hoax.classification
                Glide.with(itemView.context)
                    .load(hoax.picture1)
                    .into(picture1)
            }
            binding.root.setOnClickListener{
                onItemClickHoaxCallback?.onItemClickedhoax(hoax)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): hoaxadapter.ViewHolder {
        val newsbinding = NewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(newsbinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hoax = listhoax[position]
        holder.bindhoax(hoax)
    }

    override fun getItemCount(): Int =listhoax.size
    
    
    private var onItemClickHoaxCallback:onItemclickhoax?=null
    
    fun setOnItemClick(onItemClickHoaxCallback: onItemclickhoax){
        this.onItemClickHoaxCallback = onItemClickHoaxCallback
    }
}