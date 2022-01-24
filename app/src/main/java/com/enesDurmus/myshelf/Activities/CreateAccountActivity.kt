package com.enesDurmus.myshelf.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.enesDurmus.myshelf.CreateAccountActivityKey
import com.enesDurmus.myshelf.R
import com.enesDurmus.myshelf.StorageHandler
import com.enesDurmus.myshelf.User

/**
 *
 * @author enesdurmus
 */

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var _buttonCreateAccount: Button
    private lateinit var _textUserName: EditText
    private lateinit var _textFullName: EditText
    private lateinit var _eMail: EditText
    private lateinit var _password: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val message = intent.getStringExtra(CreateAccountActivityKey)

        _buttonCreateAccount = findViewById(R.id.buttonCreateAnAccountCa)
        _textUserName = findViewById(R.id.textUserNameCa)
        _textFullName = findViewById(R.id.textFullNameCa)
        _eMail = findViewById(R.id.textEmailCa)
        _password = findViewById(R.id.editTextPasswordCa)


        _buttonCreateAccount.setOnClickListener {
            val user: User = User(
                _textUserName.text.toString(),
                _textFullName.text.toString(),
                _eMail.text.toString(),
                _password.text.toString(),
                null
            )

            StorageHandler.WriteDataToFirebase(user.GetHashMapOfProperties())
        }
    }
}