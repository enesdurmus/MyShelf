package com.example.myshelf

/**
 *
 * @author enesdurmus
 */

class User(userName : String, fullName : String, eMail : String,password : String) {

    private var _userName : String
    private var _fullName : String
    private var _eMail : String
    private var _password : String
    private var _isRememberMeChecked : Boolean
    private var _firebaseDocumentId : String

    init {
        _userName = userName
        _fullName = fullName
        _eMail = eMail
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
