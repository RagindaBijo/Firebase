package com.example.luka12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        supportActionBar?.hide()




        buttonSendEmail.setOnClickListener {
            val email = editTextEmail.text.toString()

            if (email.isEmpty()){
                Toast.makeText(this,"Empty!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            FirebaseAuth.getInstance()
                .sendPasswordResetEmail(email)
                .addOnCompleteListener { task->
                    if (task.isSuccessful){
                        Toast.makeText(this,"Check your Email!",Toast.LENGTH_SHORT).show()

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