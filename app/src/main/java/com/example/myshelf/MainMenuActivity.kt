package com.example.myshelf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val user = intent.getSerializableExtra(MainMenuActivityKey) as? User
        Toast.makeText(this, user!!.Getsdsa(), Toast.LENGTH_SHORT).show()
    }
}