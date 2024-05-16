package com.example.myApp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.myApp.databinding.ActivityLoginBinding

class LogInActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityLoginBinding
    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userEmail = binding.edtEmailLogin
        val userPassword = binding.edtPassword

        binding.btnLoginActivity.setOnClickListener {

            if (userEmail.text.toString().isNotEmpty() && userPassword.text.toString().isNotEmpty()) {

                val sharedPreferences = getSharedPreferences("Applogin", MODE_PRIVATE)
                sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
                Log.d("Taggy", "Logged in and sharedprefence true")
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            } else {

                Toast.makeText(
                    this@LogInActivity,
                    "Please enter your Email Id & Password",
                    Toast.LENGTH_SHORT).show()
            }

        }

    }
}