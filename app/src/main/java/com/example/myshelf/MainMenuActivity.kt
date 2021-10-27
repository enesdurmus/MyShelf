package com.example.myshelf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val message = intent.getStringExtra(MainMenuActivityKey)
    }
}