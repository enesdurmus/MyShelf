package com.example.myshelf

import android.widget.Button

/**
 *
 * @author enesdurmus
 */

class User(userName : String, password : String) {

    private var _userName : String
    private var _password : String
    private var _isRememberMeSelected : Boolean

    init {
        _userName = userName
        _password = password
        _isRememberMeSelected = false
    }

    fun GetHashMapOfProperties(){

    }
}
