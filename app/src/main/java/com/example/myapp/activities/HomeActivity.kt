package com.example.myapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import com.example.myApp.AccountsFragment
import com.example.myApp.SearchToolbarActivity
import com.example.myApp.StartNewGroupActivity
import com.example.spiltwiseclone.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    lateinit var home_toolbar: androidx.appcompat.widget.Toolbar
    lateinit var addGrpsItem : MenuItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Setting Tool bar
        home_toolbar = findViewById(R.id.home_toolbar)
        home_toolbar.title = ""

        setSupportActionBar(home_toolbar)

        // Setting click listeners to tool bar elements
        home_toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.searchIcon -> {
                    val intent = Intent(this, SearchToolbarActivity::class.java)
                    startActivity(intent)
                }

                R.id.add_groups -> {
                    val intent = Intent(this, StartNewGroupActivity::class.java)
                    startActivity(intent)
                }
            }
            return@setOnMenuItemClickListener true

        }



        // Setting the default fragment
        val grpFragment = GroupsFragment()
        val accountsFragment = AccountsFragment()
        val homeFrameLayout = findViewById<FrameLayout>(R.id.home_frame_layout)
        supportFragmentManager.beginTransaction().replace(R.id.home_frame_layout, grpFragment).commit()


        // Setting the fragment on bottom navigation click
        val nav_layout = findViewById<BottomNavigationView>(R.id.bottom_nav_layout)
        nav_layout.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.itm_groups -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.home_frame_layout, grpFragment).commit()
                    addGrpsItem.isVisible = true

                }
                R.id.itm_account -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.home_frame_layout, accountsFragment).commit()
                    addGrpsItem.isVisible = false
                }
            }
            return@setOnItemSelectedListener true

        }

    }

    // Inflating menu in the tool bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_items, menu)
         addGrpsItem = home_toolbar.menu.findItem(R.id.add_groups)
        return super.onCreateOptionsMenu(menu)
    }
}