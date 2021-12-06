package com.example.hoaxhunterv2.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.hoaxhunterv2.R

class SplashScreen : AppCompatActivity() {


    private val Splashtime: Long =3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        Handler().postDelayed({
            startActivity(Intent(this,Login::class.java))
            finish()
        },Splashtime
        )
    }
}