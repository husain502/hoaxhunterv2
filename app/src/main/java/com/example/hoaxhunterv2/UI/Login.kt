package com.example.hoaxhunterv2.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.hoaxhunterv2.R
import com.example.hoaxhunterv2.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var bind:ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        auth = FirebaseAuth.getInstance()




        bind.login.setOnClickListener {
            val email = bind.email.editText.toString().trim()
            val password = bind.password.editText.toString().trim()
            val bindemail = bind.email
            val bindpassword=bind.password

            if(email.isEmpty()){
                bindemail.error = "Email harus terisi"
                bindemail.requestFocus()
                return@setOnClickListener
            }


            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                bindemail.error = "Email tidak valid"
                bindemail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length<6){
                bindpassword.error = "password harus lebih dari 6 karakter"
                bindpassword.requestFocus()
                return@setOnClickListener
            }

            loginUser(email,password)



        }
    }

    private fun loginUser (email:String, password:String){
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Intent(this@Login,Home::class.java).also{
                        startActivity(intent)
                    }
                }else{
                    Toast.makeText(this,it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onStart(){
        super.onStart()
        if(auth.currentUser !=null){
            Intent(this@Login, Home::class.java).also{
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }

}

