package com.example.myshelf

/**
 *
 * @author enesdurmus
 */

class User(userName : String, password : String) {

    private var _userName : String
    private var _password : String
    private var _isRememberMeChecked : Boolean
    private var _firebaseDocumentId : String

    init {
        _userName = userName
        _password = password
        _isRememberMeChecked = false
        _firebaseDocumentId = ""
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
