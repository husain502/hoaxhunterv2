package com.example.hoaxhunterv2.UI.Main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hoaxhunterv2.R
import com.example.hoaxhunterv2.data.Hoax
import com.example.hoaxhunterv2.databinding.NewsBinding

class Mainadapter: RecyclerView.Adapter<Mainadapter.MyViewHolder>(){
    private val listhoax = ArrayList<Hoax>()

    fun hoaxadapterlist(hoax: ArrayList<Hoax>){
        listhoax.clear()
        listhoax.addAll(hoax)
        notifyDataSetChanged()
    }


    inner class MyViewHolder(private val binding: NewsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind (hoax: Hoax){

            binding.apply {
                tanggal.text =

            }
        }
    }

 }