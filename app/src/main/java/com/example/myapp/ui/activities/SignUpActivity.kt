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
import com.example.myApp.MyAppApplication
import com.example.myApp.data.DefaultAppContainer
import com.example.myApp.data.MyAppRepository

import com.example.myApp.databinding.ActivitySignUpBinding
import javax.inject.Inject


class SignUpActivity: AppCompatActivity() {

    private lateinit var _binding: ActivitySignUpBinding
    private val binding get() = _binding

    @Inject
    lateinit var myAppRepository: MyAppRepository

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
            val userName = binding.edtUsername.editText?.text.toString()
            val userEmailId = binding.edtEmailaddress.text.toString()
            val userEmailPassword = binding.edtEmailpassword.text.toString()
            val userPhoneNumber = binding.edtPhonenumber.text.toString()
            if (userName.isEmpty() || userEmailId.isEmpty() || userEmailPassword.isEmpty() || userPhoneNumber.isEmpty()
                ) {
                Toast.makeText(
                    this@SignUpActivity,
                    "Please enter all details",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // Saving User data to SharedPreferences
                savingDataToSharedPreference(
                    userName = userName,
                    userEmailId = userEmailId,
                    userEmailPassword= userEmailPassword,
                    userPhoneNumber= userPhoneNumber)


                // Launching Home Activity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }


    private fun openUserGallery() {

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

    private fun savingDataToSharedPreference(
        userName: String,
        userEmailId: String,
        userEmailPassword: String,
        userPhoneNumber: String) {

        val sharedPreferences = getSharedPreferences("Applogin", MODE_PRIVATE)
        sharedPreferences.edit().apply {
            putString("userName", userName)
            putString("userEmailID", userEmailId)
            putString("userEmailPassword", userEmailPassword)
            putString("userPhoneNumber", userPhoneNumber)
            putBoolean("isLoggedIn",true)
        }.apply()

    }


}