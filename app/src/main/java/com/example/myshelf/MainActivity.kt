package com.example.myshelf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import com.google.firebase.firestore.FirebaseFirestore


/**
 *
 * @author enesdurmus
 */

class MainActivity : AppCompatActivity() {

    val UserDataFileName : String = "UserData"
    var UserData : HashMap<String, Any>? = null

    lateinit var _user : User
    lateinit var _textUserName : EditText
    lateinit var _textPassword : EditText

    lateinit var _buttonLogin : Button
    lateinit var _buttonCreateAccount : Button
    lateinit var _buttonForgotPassword : Button

    lateinit var _radioButtonRememberMe : RadioButton

    lateinit var _storageHandler : StorageHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _user = User("enes", "3752590ev")

        _storageHandler = StorageHandler("sea")

        _radioButtonRememberMe = findViewById(R.id.radioButtonRememberMe)
        _buttonLogin = findViewById(R.id.buttonLogin)
        _buttonCreateAccount = findViewById(R.id.buttonCreateAnAccount)
        _textUserName = findViewById(R.id.textUserName)

        _buttonCreateAccount.setOnClickListener{

        }

        _radioButtonRememberMe.setOnClickListener{

            ToggleRememberMeButton()

            val user: MutableMap<String, Any> = HashMap()
            user["userName"] = "Enes"
            user["last"] = "Lovelace"
            user["ula"] = "xd"
            user["born"] = 1815

            _storageHandler.WriteDataToFile(UserDataFileName, user)
        }

        _buttonLogin.setOnClickListener{
            UserData = _storageHandler.ReadDataFromFile(UserDataFileName)
            _textUserName.setText(UserData?.getValue("first").toString())
        }
    }

    fun ToggleRememberMeButton(){
        _user.ToggleIsRememberMeChecked()
        _radioButtonRememberMe.isChecked = _user.GetIsRememberMeChecked()
    }
}