package com.example.luka12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_change_password.*

class ChangePasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        supportActionBar?.hide()



        buttonChangePassword.setOnClickListener {
            val newPassword=editTextNewPassword.text.toString()


            if (newPassword.length > 6 ){
                FirebaseAuth.getInstance()
                    .currentUser?.updatePassword(newPassword)
                    ?.addOnCompleteListener{task->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
                            val intent=Intent(this,MainActivity::class.java)
                            startActivity(intent)
                            finish()

                        } else {
                            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                        }
                    }


            }



        }





    }
}