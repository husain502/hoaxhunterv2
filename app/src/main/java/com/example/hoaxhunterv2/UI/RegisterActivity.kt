package com.example.hoaxhunterv2.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.hoaxhunterv2.R
import com.example.hoaxhunterv2.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth:FirebaseAuth
    private lateinit var bind:ActivityRegisterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth= FirebaseAuth.getInstance()

        bind.btnregister.setOnClickListener{
            val email = bind.email.editText.toString().trim()
            val password = bind.password.editText.toString().trim()
            val username = bind.username.editText.toString().trim()


            if(email.isEmpty()){
                bind.email.error = "Email harus terisi"
                bind.email.requestFocus()
                return@setOnClickListener
            }
            if (username.isEmpty()){
                bind.username.error = "username harus terisi"
                bind.username.requestFocus()
                return@setOnClickListener
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                bind.email.error = "Email tidak valid"
                bind.email.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length<6){
                bind.password.error = "password harus lebih dari 6 karakter"
                bind.password.requestFocus()
                return@setOnClickListener
            }

            registerUser(email,password)
        }

        }
    private fun registerUser(email:String, password:String){
    auth.createUserWithEmailAndPassword(email,password)
        .addOnCompleteListener(this){
            if(it.isSuccessful){
                Intent(this@RegisterActivity,Home::class.java).also{
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }else {
                Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
                }
    override fun onStart() {
        super.onStart()
        if(auth.currentUser != null){
            Intent(this@RegisterActivity, Home::class.java).also{
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }}


}


