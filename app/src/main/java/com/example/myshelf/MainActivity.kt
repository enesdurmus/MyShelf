package com.example.myshelf

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import com.google.firebase.firestore.FirebaseFirestore
import org.w3c.dom.UserDataHandler
import java.io.FileInputStream
import java.io.FileOutputStream
import java.lang.Exception

/**
 *
 * @author enesdurmus
 */

class MainActivity : AppCompatActivity() {

    val UserDataFileName : String = "UserData"
    var UserData : HashMap<String, Any>? = null

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

        _internalStorageHandler = InternalStorageHandler()

        _radioButtonRememberMe = findViewById(R.id.radioButtonRememberMe)
        _buttonLogin = findViewById(R.id.buttonLogin)
        _textUserName = findViewById(R.id.textUserName)

        val db = FirebaseFirestore.getInstance()
        _radioButtonRememberMe.setOnClickListener{

            val user: MutableMap<String, Any> = HashMap()
            user["first"] = "Ada"
            user["last"] = "Lovelace"
            user["ula"] = "xd"
            user["born"] = 1815

            db.collection("users").add(user).addOnSuccessListener {
                Log.d("sea","sea")
            }
            _internalStorageHandler.WriteDataToFile(UserDataFileName, user)
        }

        _buttonLogin.setOnClickListener{
            _internalStorageHandler.ReadDataFromFile(UserDataFileName)
        }
    }
}