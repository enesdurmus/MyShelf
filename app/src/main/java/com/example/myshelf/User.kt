package com.example.myshelf

import java.io.Serializable

/**
 *
 * @author enesdurmus
 */

class User(userName: String, fullName: String, eMail: String, password: String) : Serializable{

    private var _userName: String
    private var _fullName: String
    private var _eMail: String
    private var _password: String
    private var _isRememberMeChecked: Boolean
    private var _firebaseDocumentId: String
    private lateinit var _movies : HashMap<String, String>

    init {
        _userName = userName
        _fullName = fullName
        _eMail = eMail
        _password = password
        _isRememberMeChecked = false
        _firebaseDocumentId = ""
    }

    fun GetHashMapOfProperties(): HashMap<String, Any> {
        val propertiesMap: HashMap<String, Any> = HashMap()
        propertiesMap["UserName"] = _userName
        propertiesMap["FullName"] = _fullName
        propertiesMap["E-mail"] = _eMail
        propertiesMap["Password"] = _password
       // propertiesMap["IsRememberMeChecked"] = _isRememberMeChecked
        return propertiesMap
    }

    fun GetIsRememberMeChecked(): Boolean {
        return _isRememberMeChecked
    }

    fun ToggleIsRememberMeChecked() {
        _isRememberMeChecked = !_isRememberMeChecked
    }

    fun Getsdsa() : String{
        return _fullName
    }

    companion object{
        fun CreateUserWithData(data : Map<String, Any>) : User{
            val user = User(
                data.getValue("UserName") as String,
                data.getValue("FullName") as String,
                data.getValue("E-mail") as String,
                data.getValue("Password") as String
            )

            return user
        }
    }
}
