package com.example.hoaxhunterv2.UI

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hoaxhunterv2.Detail.Hoaxdetail.Companion.EXTRA_ID
import com.example.hoaxhunterv2.Utilss.Viewmodelfactory
import com.example.hoaxhunterv2.Utilss.onItemclickhoax
import com.example.hoaxhunterv2.adapter.hoaxadapter
import com.example.hoaxhunterv2.database.remote.hoax.detailhoax
import com.example.hoaxhunterv2.database.remote.modelhoax
import com.example.hoaxhunterv2.databinding.FragmentHoaxBinding
import com.example.hoaxhunterv2.viewmodel.viewmodelhoax


class Hoax : Fragment() {

    private lateinit var fragmentHoaxBinding: FragmentHoaxBinding
    private lateinit var viewmodel: viewmodelhoax


    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?):View? {
        fragmentHoaxBinding = FragmentHoaxBinding.inflate(layoutInflater,container,false)
        return fragmentHoaxBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val HoaxAdapter = hoaxadapter()
            HoaxAdapter.notifyDataSetChanged()
            HoaxAdapter.setOnItemClick(object : onItemclickhoax{
                override fun onItemClickedhoax(hoaks: modelhoax) {
                    Intent(activity,detailhoax::class.java).also{
                        it.putExtra(EXTRA_ID,hoaks.id)
                        startActivity(it)
                    }
                }

            })

            fragmentHoaxBinding.apply {
                rvmain.layoutManager = LinearLayoutManager(context)
                rvmain.setHasFixedSize(true)
                rvmain.adapter = HoaxAdapter
            }
            val factory = Viewmodelfactory.getInstance()
            viewmodel = ViewModelProvider(this,factory)[viewmodelhoax::class.java]
            viewmodel.takehoaxdata().observe(viewLifecycleOwner,{
                if(it != null){
                    HoaxAdapter.setHoax(it)
                    fragmentHoaxBinding.rvmain.visibility = View.VISIBLE
            }

            })
        }}

}