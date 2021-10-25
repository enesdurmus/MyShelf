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
        val propertiesHashMap: HashMap<String, Any> = HashMap()
        propertiesHashMap["UserName"] = _userName
        propertiesHashMap["FullName"] = _fullName
        propertiesHashMap["E-mail"] = _eMail
        propertiesHashMap["Password"] = _password
        return propertiesHashMap
    }

    fun GetIsRememberMeChecked(): Boolean {
        return _isRememberMeChecked
    }

    fun ToggleIsRememberMeChecked() {
        _isRememberMeChecked = !_isRememberMeChecked
    }
}
