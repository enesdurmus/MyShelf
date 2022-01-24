package com.enesDurmus.myshelf

import java.io.Serializable

/**
 *
 * @author enesdurmus
 */

class User(userName: String, fullName: String, eMail: String, password: String, movies: HashMap<String, Any>?) : Serializable {

    internal var _userName: String
        get() = field
    internal var _fullName: String
        get() = field
    internal var _eMail: String
        get() = field
    internal var _password: String
        get() = field
    internal var _firebaseDocumentId: String
        get() = field
    internal var _movies: HashMap<String, Any>
        get() = field

    init {
        _userName = userName
        _fullName = fullName
        _eMail = eMail
        _password = password
        _firebaseDocumentId = ""
        if (movies != null) {
            _movies = movies
        }else{
            _movies = HashMap()
        }
    }

    fun GetHashMapOfProperties(): HashMap<String, Any> {
        val propertiesMap: HashMap<String, Any> = HashMap()
        propertiesMap["UserName"] = _userName
        propertiesMap["FullName"] = _fullName
        propertiesMap["E-mail"] = _eMail
        propertiesMap["Password"] = _password
        propertiesMap["Movies"] = _movies
        return propertiesMap
    }

    companion object {
        fun CreateUserWithData(data: Map<String, Any>): User {
            val user = User(
                data.getValue("UserName") as String,
                data.getValue("FullName") as String,
                data.getValue("E-mail") as String,
                data.getValue("Password") as String,
                data.getValue("Movies") as HashMap<String, Any>
            )

            return user
        }
    }
}
