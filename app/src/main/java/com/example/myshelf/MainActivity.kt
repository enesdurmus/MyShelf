package com.example.myshelf

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
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

        _radioButtonRememberMe = findViewById(R.id.radioButtonRememberMe)
        _buttonLogin = findViewById(R.id.buttonLogin)
        _textUserName = findViewById(R.id.textUserName)

        _internalStorageHandler = InternalStorageHandler(_textUserName)

        _radioButtonRememberMe.setOnClickListener{
            GetUserDataInternal()
        }



      //  button = findViewById(R.id.button2)

        //val db = FirebaseFirestore.getInstance()

        _buttonLogin.setOnClickListener{
            UpdateUserDataInternal()
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

    fun GetUserDataInternal(){
        ReadData(UserDataFileName)
    }

    fun UpdateUserDataInternal(){
        val user: MutableMap<String, Any> = HashMap()
        user["first"] = "Ada"
        user["last"] = "Lovelace"
        user["ula"] = "xd"
        user["born"] = 1815

        SaveData(UserDataFileName, user)
    }

    fun SaveData(fileName : String, data : Any){
        try{
            var fos : FileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE)
            _internalStorageHandler.WriteDataToFile(data, fos)
        }catch (e : Exception){
            Log.d("Exception1", e.message.toString())
        }
    }

    fun ReadData(fileName : String){
        try{
            var fis : FileInputStream = openFileInput(fileName)
            val mapInFile : HashMap<String, Any>? = _internalStorageHandler.ReadDataFromFile(fis)
        }catch (e : Exception){
            Log.d("Exception2", e.message.toString())
        }
    }
}