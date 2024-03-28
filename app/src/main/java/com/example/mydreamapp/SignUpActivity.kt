package com.example.mydreamapp

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.addTextChangedListener
import com.example.spiltwiseclone.R

class SignUpActivity : AppCompatActivity() {

    companion object {

        const val REQUEST_CODE = 3
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val userName = findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.edt_username)
        val innerConstraintlayout = findViewById<ConstraintLayout>(R.id.inner_constraint_layout)
        val userProfilePhoto = findViewById<ImageView>(R.id.img_profile_photo)
        val userEmailId = findViewById<EditText>(R.id.edt_emailaddress)
        val userPassword = findViewById<EditText>(R.id.edt_emailpassword)
        val countryCode = findViewById<EditText>(R.id.edt_country_code)
        val userPhoneNumber = findViewById<EditText>(R.id.edt_phonenumber)
        val currencySuggestionText = findViewById<TextView>(R.id.txt_currency_suggestion)
        val backBtn = findViewById<Button>(R.id.btn_back)
        val doneBtn = findViewById<Button>(R.id.btn_done)

        val userNameTextField  = userName.editText
        userNameTextField?.addTextChangedListener {
            Log.d("Taggy", it.toString())
            if(it.toString().length == 2) {

                innerConstraintlayout.visibility  = View.VISIBLE
            }
        }

        // Setting onclick listener for Profile Image
         userProfilePhoto.setOnClickListener {
            openUserGallery()
        }
    }


    fun openUserGallery() {

        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {

            val imageUri: Uri? = data.data
            if(imageUri != null) {
             val  bitMap = BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri))



            }


        }


    }




}