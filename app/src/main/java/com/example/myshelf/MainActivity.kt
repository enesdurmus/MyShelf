package com.example.myshelf

import android.content.Intent
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

const val CreateAccountActivityKey = "com.example.MyShelf.CreateAccount"
const val UserDataFileName : String = "UserData"

class MainActivity : AppCompatActivity() {

    private var UserData : HashMap<String, Any>? = null

    private lateinit var _user : User
    private lateinit var _textUserName : EditText
    private lateinit var _textPassword : EditText

    private lateinit var _buttonLogin : Button
    private lateinit var _buttonCreateAccount : Button
    private lateinit var _buttonForgotPassword : Button

    private lateinit var _radioButtonRememberMe : RadioButton

    private lateinit var _storageHandler : StorageHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _user = User("enes", "3752590ev", "as", "s")

        _storageHandler = StorageHandler("sea")

        _radioButtonRememberMe = findViewById(R.id.radioButtonRememberMe)
        _buttonLogin = findViewById(R.id.buttonLogin)
        _buttonCreateAccount = findViewById(R.id.buttonCreateAnAccount)
        _textUserName = findViewById(R.id.textUserName)

        HandleCreateAccountButton()

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
            _storageHandler.ReadDataFromFirebase()

            //UserData = _storageHandler.ReadDataFromFile(UserDataFileName)
          //  _textUserName.setText(UserData?.getValue("first").toString())
        }
    }

    fun ToggleRememberMeButton(){
        _user.ToggleIsRememberMeChecked()
        _radioButtonRememberMe.isChecked = _user.GetIsRememberMeChecked()
    }

    fun HandleCreateAccountButton() {
        _buttonCreateAccount.setOnClickListener{
            val message = "selam"
            val intent = Intent(this, CreateAccountActivity::class.java).apply {
                putExtra(CreateAccountActivityKey, message)
            }
            startActivity(intent)
        }
    }
}