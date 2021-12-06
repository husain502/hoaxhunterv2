package com.example.hoaxhunterv2.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hoaxhunterv2.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //hostfragment

        val navView:BottomNavigationView=findViewById(R.id.nav_bottom)
        val navController = findNavController(R.id.nav_host_fragment)



        val appBarConfiguration = AppBarConfiguration.Builder(
                R.id.HoaxNav, R.id.ProfileNav)
                .build()


        setupActionBarWithNavController(navController,appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    }





