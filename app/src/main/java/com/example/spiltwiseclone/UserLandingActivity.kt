package com.example.spiltwiseclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UserLandingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_landing)

        val signUpBtn = findViewById<Button>(R.id.btn_signup)
        val logInBtn = findViewById<Button>(R.id.btn_login)
        val googleSignInBtn = findViewById<Button>(R.id.btn_signin_with_google)

        signUpBtn.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)

        }


    }
}