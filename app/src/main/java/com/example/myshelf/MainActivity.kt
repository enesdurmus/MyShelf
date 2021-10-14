package com.example.myshelf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.NonNull

import com.google.android.gms.tasks.OnFailureListener

import com.google.firebase.firestore.DocumentReference

import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestore







class MainActivity : AppCompatActivity() {

    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button2)

        val db = FirebaseFirestore.getInstance()

        button.setOnClickListener{

            val user: MutableMap<String, Any> = HashMap()
            user["first"] = "Ada"
            user["last"] = "Lovelace"
            user["born"] = 1815

            db.collection("users").add(user).addOnSuccessListener {
                print("sea")
            }


        }
    }
}