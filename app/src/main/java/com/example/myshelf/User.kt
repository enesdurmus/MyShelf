package com.example.myshelf

import android.widget.Button

/**
 *
 * @author enesdurmus
 */

class User(userName : String, password : String) {

    private var _userName : String
    private var _password : String
    private var _isRememberMeChecked : Boolean

    init {
        _userName = userName
        _password = password
        _isRememberMeChecked = false
    }

    fun GetHashMapOfProperties(){

    }

    fun GetIsRememberMeChecked() : Boolean{
        return _isRememberMeChecked
    }

    fun ToggleIsRememberMeChecked(){
        _isRememberMeChecked = !_isRememberMeChecked
    }
}
