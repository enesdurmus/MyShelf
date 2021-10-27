package com.example.myshelf

/**
 *
 * @author enesdurmus
 */

class User(userName: String, fullName: String, eMail: String, password: String) {

    private var _userName: String
    private var _fullName: String
    private var _eMail: String
    private var _password: String
    private var _isRememberMeChecked: Boolean
    private var _firebaseDocumentId: String

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
}
