package com.example.myshelf

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

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
            var fos : FileOutputStream? = openFileOutput("example.txt", Context.MODE_APPEND)
            if (fos != null) {
                _internalStorageHandler.WriteDataToFile("seaaaaa".toByteArray(), fos)
            }
        }



      //  button = findViewById(R.id.button2)

        //val db = FirebaseFirestore.getInstance()

        _buttonLogin.setOnClickListener{
            var fis : FileInputStream? = openFileInput("example.txt")
            if (fis != null) {
                _internalStorageHandler.ReadDataFromFile(fis)
            }
        //_internalStorageHandler.ReadDataFromFile()
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