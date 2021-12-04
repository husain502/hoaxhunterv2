package com.example.hoaxhunterv2.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.hoaxhunterv2.R
import com.example.hoaxhunterv2.Utilss.Viewmodelfactory
import com.example.hoaxhunterv2.databinding.DetailhoaxBinding

class Hoaxdetail : AppCompatActivity() {
    companion object{
                const val EXTRA_TITLE = "EXTRA_TITLE"
                const val EXTRA_ID = "EXTRA_ID"
                const val EXTRA_PICTURE = "EXTRA PICTURE"
                const val EXTRA_CLASSIFICATION = "EXTRA CLASSIFICATION"
                const val EXTRA_FACT = "EXTRA FACT"
    }
    private lateinit var detailhoaxBinding: DetailhoaxBinding
    private lateinit var viewmodel:viewmodelhoaxdetail



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailhoaxBinding= DetailhoaxBinding.inflate(layoutInflater)
        setContentView(detailhoaxBinding.root)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val factory = Viewmodelfactory.getInstance()
        viewmodel = ViewModelProvider(this,factory)[viewmodelhoaxdetail::class.java]

        setDetailhoax()
        viewmodel.getdetailhoax().observe(this,{
            if(it != null){
                detailhoaxBinding.title.text = it.title
                //supportactiobar
                detailhoaxBinding.fact.text = it.fact
                detailhoaxBinding.typehoaks.text=it.classification
                detailhoaxBinding.content.text=it.content
                Glide.with(this)
                    .load(it.picture1)
                    .transform(RoundedCorners(4))
                    .into(detailhoaxBinding.picture1)
            }
        })

    }
    override fun onSupportNavigateUp(): Boolean{
        onBackPressed()
        return true

    }
    private fun setDetailhoax(){
        val id = intent.getIntExtra(EXTRA_ID,0)
        val factory = Viewmodelfactory.getInstance()
        viewmodel = ViewModelProvider(this,factory)[viewmodelhoaxdetail::class.java]
        viewmodel.id = id
    }
}