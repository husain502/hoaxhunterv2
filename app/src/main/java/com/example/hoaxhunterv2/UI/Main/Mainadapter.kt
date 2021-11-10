package com.example.hoaxhunterv2.UI.Main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.hoaxhunterv2.R
import com.example.hoaxhunterv2.UI.Detail.Detailhoax
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
                picture1.loadImage(hoax.picture1)
                title.text = hoax.title
                typehoaks.text = hoax.classification
            }
        }
    }
    private  fun ImageView.loadImage(url:String?){
        Glide.with(this.context)
                .load(url)
                .apply(RequestOptions().override(500,500))
                .into(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = NewsBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val pos = listhoax[position]
        holder.bind(pos)
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,Detailhoax::class.java).apply {
                putExtra(Detailhoax.EXTRA_TITLE,pos.title)
                putExtra(Detailhoax.EXTRA_ID,pos.id)
                putExtra(Detailhoax.EXTRA_PICTURE,pos.picture1)
                putExtra(Detailhoax.EXTRA_CLASSIFICATION,pos.classification)
            }
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listhoax.size
}


