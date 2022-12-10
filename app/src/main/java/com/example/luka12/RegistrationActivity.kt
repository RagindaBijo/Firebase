package com.example.luka12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        supportActionBar?.hide()



        buttonRegistration.setOnClickListener {
            val email = editTextEmailAddress.text.toString()
            val password=editTextPassword.text.toString()
            val repeatPassword=editTextRepeatPassword.text.toString()

            if (email.isEmpty()||password.isEmpty()||repeatPassword.isEmpty()){
                Toast.makeText(this,"Empty!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if (repeatPassword!=password){
                Toast.makeText(this,"Passwords do not match",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener{task->
                    if (task.isSuccessful){
                        val intent=Intent(this,LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this,"Error!",Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}