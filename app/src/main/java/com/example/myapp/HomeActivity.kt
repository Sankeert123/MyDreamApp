package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toolbar
import com.example.spiltwiseclone.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.concurrent.fixedRateTimer

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Setting Tool bar
        val home_toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.home_toolbar)
        home_toolbar.title = ""
        setSupportActionBar(home_toolbar)

        // Setting the default fragment
        val grpFragment = GroupsFragment()
        val homeFrameLayout = findViewById<FrameLayout>(R.id.home_frame_layout)
        supportFragmentManager.beginTransaction().replace(R.id.home_frame_layout, grpFragment).commit()

        // Setting the fragment on bottom navigation click
        val nav_layout = findViewById<BottomNavigationView>(R.id.bottom_nav_layout)
        nav_layout.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.itm_groups -> {
                    if (homeFrameLayout == null) {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.home_frame_layout, grpFragment).commit()
                    }
                }
            }
            return@setOnItemSelectedListener true

        }

    }

    // Inflating menu in the tool bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_items, menu)
        return super.onCreateOptionsMenu(menu)
    }
}