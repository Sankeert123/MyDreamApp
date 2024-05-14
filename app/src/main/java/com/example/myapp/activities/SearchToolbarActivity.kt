package com.example.myApp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myApp.R
import com.example.myApp.databinding.ActivitySearchToolbarBinding

class SearchToolbarActivity : AppCompatActivity() {

    private lateinit var _binding: ActivitySearchToolbarBinding

    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySearchToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}