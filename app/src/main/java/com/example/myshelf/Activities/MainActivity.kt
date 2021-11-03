package com.example.myshelf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast


/**
 *
 * @author enesdurmus
 */

enum class LoginCallState {
    Found, NotFound, Error
}

const val CreateAccountActivityKey = "com.example.MyShelf.CreateAccount"
const val MainMenuActivityKey = "com.example.MyShelf.MainMenu"
const val UserDataFileName: String = "UserData"

class MainActivity : AppCompatActivity() {

    private lateinit var _textUserName: EditText
    private lateinit var _textPassword: EditText

    private lateinit var _buttonLogin: Button
    private lateinit var _buttonCreateAccount: Button
    private lateinit var _buttonForgotPassword: Button

    private lateinit var _radioButtonRememberMe: RadioButton

    private var _isRadioButtonChecked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        Init()

        _radioButtonRememberMe = findViewById(R.id.radioButtonRememberMe)
        _buttonLogin = findViewById(R.id.buttonLogin)
        _buttonCreateAccount = findViewById(R.id.buttonCreateAnAccount)
        _textUserName = findViewById(R.id.textUserName)
        _textPassword = findViewById(R.id.textPassword)

        HandleCreateAccountButton()
        HandleLoginButton()
        HandleRememberMeRadioButton()

        /*  val user: MutableMap<String, Any> = HashMap()
          user["userName"] = "Enes"
          user["last"] = "Lovelace"
          user["ula"] = "xd"
          user["born"] = 1815

          _storageHandler.WriteDataToFile(UserDataFileName, user)*/
    }

    fun Init() {
        if (CheckIsRememberMeSelected() == false) {
            var userData: Map<String, Any>? = StorageHandler.ReadDataFromFile(UserDataFileName)
            if (userData != null) {
                LoginAccount(User.CreateUserWithData(userData))
            }
        }
    }

    fun CheckIsRememberMeSelected(): Boolean? {
        return StorageHandler.ReadDataFromFile(UserDataFileName)?.isEmpty()
    }

    fun HandleLoginButton() {
        _buttonLogin.setOnClickListener {
            StorageHandler.ReadDataFromFirebase(_textUserName.text.toString(), ::OnUserDataRead)
        }
    }

    fun HandleRememberMeRadioButton() {
        _radioButtonRememberMe.setOnClickListener {
            ToggleRememberMeButton()
        }
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

    fun ToggleRememberMeButton() {
        _radioButtonRememberMe.isChecked = !_isRadioButtonChecked
        _isRadioButtonChecked = !_isRadioButtonChecked
    }

    fun OnUserDataRead(state: LoginCallState, data: Map<String, Any>?) {
        if (state == LoginCallState.Found) {
            if (data != null) {
                if (CheckPassword(data.getValue("Password").toString())) {
                    if (_isRadioButtonChecked) {
                        StorageHandler.WriteDataToFile(UserDataFileName, data)
                    }
                    LoginAccount(User.CreateUserWithData(data))
                }
            }
        } else if (state == LoginCallState.NotFound) {
            Toast.makeText(this, "User Not Found.", Toast.LENGTH_SHORT).show()
        } else if (state == LoginCallState.Error) {
            Toast.makeText(this, "Error.", Toast.LENGTH_SHORT).show()
        }
    }

    fun LoginAccount(user: User) {
        val intent = Intent(this, DashBoardActivity::class.java).apply {
            putExtra(MainMenuActivityKey, user)
        }
        startActivity(intent)
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