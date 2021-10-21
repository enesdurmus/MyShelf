package com.example.myshelf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val message = intent.getStringExtra(CreateAccountActivityKey)

        val textView = findViewById<TextView>(R.id.textUserNameCa).apply {
            text = message
        }
    }
}