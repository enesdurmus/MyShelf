package com.example.myshelf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 *
 * @author enesdurmus
 */


class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        var user = intent.getSerializableExtra(MainMenuActivityKey) as User
        Toast.makeText(this, user._userName, Toast.LENGTH_SHORT).show()

        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navBarHome -> {
                    // Respond to navigation item 1 click
                    true
                }
                R.id.navBarSearchPage -> {
                    // Respond to navigation item 2 click
                    true
                }
                else -> false
            }
        }

    }
}