package com.example.spiltwiseclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.addTextChangedListener

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val userName = findViewById<EditText>(R.id.edt_username)
        val innerConstraintlayout = findViewById<ConstraintLayout>(R.id.inner_constraint_layout)
        val userProfilePhoto = findViewById<ImageView>(R.id.img_profile_photo)
        val userEmailId = findViewById<EditText>(R.id.edt_emailaddress)
        val userPassword = findViewById<EditText>(R.id.edt_emailpassword)
        val countryCode = findViewById<EditText>(R.id.edt_country_code)
        val userPhoneNumber = findViewById<EditText>(R.id.edt_phonenumber)
        val currencySuggestionText = findViewById<TextView>(R.id.txt_currency_suggestion)
        val backBtn = findViewById<Button>(R.id.btn_back)
        val doneBtn = findViewById<Button>(R.id.btn_done)


        userName.addTextChangedListener {
            Log.d("Taggy", it.toString())
            if(it.toString().length == 2) {

                innerConstraintlayout.visibility  = View.VISIBLE
            }
        }

    }
}