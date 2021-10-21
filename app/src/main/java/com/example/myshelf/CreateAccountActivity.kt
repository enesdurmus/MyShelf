package com.example.myshelf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var _storageHandler : StorageHandler
    private lateinit var _buttonCreateAccount : Button
    private lateinit var _textUserName : EditText
    private lateinit var _textFullName : EditText
    private lateinit var _eMail : EditText
    private lateinit var _password : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val message = intent.getStringExtra(CreateAccountActivityKey)

        _buttonCreateAccount = findViewById(R.id.buttonCreateAnAccountCa)
        _textUserName = findViewById(R.id.textUserNameCa)
        _textFullName = findViewById(R.id.textFullNameCa)
        _eMail = findViewById(R.id.textEmailCa)
        _password = findViewById(R.id.editTextPasswordCa)

        _storageHandler = StorageHandler("sea")

        _buttonCreateAccount.setOnClickListener{
            val user: HashMap<String, Any> = HashMap()
            user["UserName"] = _textUserName.text.toString()
            user["FullName"] = _textFullName.text.toString()
            user["E-mail"] = _eMail.text.toString()
            user["Password"] = _password.text.toString()

            _storageHandler.WriteDataToFirebase(user)
        }
    }
}