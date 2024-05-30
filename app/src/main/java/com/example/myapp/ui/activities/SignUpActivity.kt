package com.example.myApp.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.myApp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var _binding: ActivitySignUpBinding
    private val binding get() = _binding

    companion object {

        const val REQUEST_CODE = 3
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val userNameTextField  = binding.edtUsername.editText
        userNameTextField?.addTextChangedListener {

            Log.d("Taggy", it.toString())
            if(it.toString().length == 2) {

                binding.innerConstraintLayout.visibility  = View.VISIBLE
            }
        }

        // Setting onclick listener for Profile Image
         binding.imgProfilePhoto.setOnClickListener {
            openUserGallery()
        }

        // Setting onclick for Done button
        binding.btnDone.setOnClickListener {
            if (binding.edtUsername.editText?.text.toString().isEmpty()) {
                Toast.makeText(
                    this@SignUpActivity,
                    "Please enter your name",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val sharedPreferences = getSharedPreferences("Applogin", MODE_PRIVATE)
                sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }


    fun openUserGallery() {

        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_CODE)

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {

            val imageUri: Uri? = data.data
            if(imageUri != null) {
             val  bitMap = BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri))

                binding.imgProfilePhoto.setImageBitmap(bitMap)
                binding.imgProfilePhoto.background = null


            }


        }


    }




}