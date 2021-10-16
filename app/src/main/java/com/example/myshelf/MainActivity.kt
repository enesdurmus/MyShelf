package com.example.myshelf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import com.google.firebase.firestore.FirebaseFirestore

/**
 *
 * @author enesdurmus
 */


class MainActivity : AppCompatActivity() {

    lateinit var _textUserName : EditText
    lateinit var _textPassword : EditText

    lateinit var _buttonLogin : Button
    lateinit var _buttonCreateAccount : Button
    lateinit var _buttonForgotPassword : Button

    lateinit var _radioButtonRememberMe : RadioButton

    lateinit var _internalStorageHandler : InternalStorageHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _radioButtonRememberMe = findViewById(R.id.radioButtonRememberMe)
        _buttonLogin = findViewById(R.id.buttonLogin)
        _textUserName = findViewById(R.id.textUserName)

        _internalStorageHandler = InternalStorageHandler(_textUserName)

        _radioButtonRememberMe.setOnClickListener{
            _internalStorageHandler.WriteDataToFile("seaaaaa".toByteArray())
        }



      //  button = findViewById(R.id.button2)

        //val db = FirebaseFirestore.getInstance()

        _buttonLogin.setOnClickListener{
         //   xd.ReadDataFromFile()
/*
            val user: MutableMap<String, Any> = HashMap()
            user["first"] = "Ada"
            user["last"] = "Lovelace"
            user["ula"] = "xd"
            user["born"] = 1815

            db.collection("users").add(user).addOnSuccessListener {
                print("sea")
            }

*/
        }
    }
}