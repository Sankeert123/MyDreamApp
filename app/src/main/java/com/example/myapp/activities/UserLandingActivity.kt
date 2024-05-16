package com.example.myApp.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.myApp.R
import com.example.myApp.databinding.ActivityUserLandingBinding

class UserLandingActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityUserLandingBinding
    private val binding get() = _binding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityUserLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SharedPreferences for remembering login data and launching based on that
        sharedPreferences = getSharedPreferences("Applogin", MODE_PRIVATE)
        val isLogIn = sharedPreferences.getBoolean("isLoggedIn", false)
        Log.d("Taggy", "Default sharedPreferences is false")

        if(isLogIn) {
            Log.d("Taggy", "IsLogin true and Launching Home page")
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

    }
}