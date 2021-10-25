package com.example.myshelf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast


/**
 *
 * @author enesdurmus
 */

const val CreateAccountActivityKey = "com.example.MyShelf.CreateAccount"
const val UserDataFileName: String = "UserData"

enum class LoginCallState {
    Found, NotFound, Error
}

class MainActivity : AppCompatActivity() {

    private var UserData: HashMap<String, Any>? = null

    private lateinit var _user: User
    private lateinit var _textUserName: EditText
    private lateinit var _textPassword: EditText

    private lateinit var _buttonLogin: Button
    private lateinit var _buttonCreateAccount: Button
    private lateinit var _buttonForgotPassword: Button

    private lateinit var _radioButtonRememberMe: RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _user = User("enes", "3752590ev", "as", "s")


        _radioButtonRememberMe = findViewById(R.id.radioButtonRememberMe)
        _buttonLogin = findViewById(R.id.buttonLogin)
        _buttonCreateAccount = findViewById(R.id.buttonCreateAnAccount)
        _textUserName = findViewById(R.id.textUserName)
        _textPassword = findViewById(R.id.textPassword)

        HandleCreateAccountButton()

        _radioButtonRememberMe.setOnClickListener {

            ToggleRememberMeButton()

            /*  val user: MutableMap<String, Any> = HashMap()
              user["userName"] = "Enes"
              user["last"] = "Lovelace"
              user["ula"] = "xd"
              user["born"] = 1815

              _storageHandler.WriteDataToFile(UserDataFileName, user)*/
        }

        _buttonLogin.setOnClickListener {
            StorageHandler.ReadDataFromFirebase(_textUserName.text.toString(), ::OnUserDataRead)

            //UserData = _storageHandler.ReadDataFromFile(UserDataFileName)
            //  _textUserName.setText(UserData?.getValue("first").toString())
        }
    }

    fun ToggleRememberMeButton() {
        _user.ToggleIsRememberMeChecked()
        _radioButtonRememberMe.isChecked = _user.GetIsRememberMeChecked()
    }

    fun HandleCreateAccountButton() {
        _buttonCreateAccount.setOnClickListener {
            val message = "selam"
            val intent = Intent(this, CreateAccountActivity::class.java).apply {
                putExtra(CreateAccountActivityKey, message)
            }
            startActivity(intent)
        }
    }

    fun OnUserDataRead(state: LoginCallState, password: String?) {
        if (state == LoginCallState.Found) {
            if (password != null) {
                CheckPassword(password)
            }
        } else if (state == LoginCallState.NotFound) {
            Toast.makeText(this, "User Not Found.", Toast.LENGTH_SHORT).show()
        } else if (state == LoginCallState.Error) {
            Toast.makeText(this, "Error.", Toast.LENGTH_SHORT).show()
        }
    }

    fun CheckPassword(password: String): Boolean {
        if (_textPassword.text.toString() == password) {
            Toast.makeText(this, "Gir", Toast.LENGTH_SHORT).show()
            return true
        }
        Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show()
        return false
    }
}