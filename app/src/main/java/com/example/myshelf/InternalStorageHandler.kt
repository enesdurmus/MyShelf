package com.example.myshelf

import android.util.Log
import android.widget.EditText
import java.io.*

/**
 *
 * @author enesdurmus
 */

class InternalStorageHandler(debeme: EditText){

    private val _texttt : EditText

    init {
        _texttt = debeme
    }

    public fun WriteDataToFile(data: Any, fos: FileOutputStream){
        try {
            var ous = ObjectOutputStream(fos)
            ous.writeObject(data)
            ous.close()
            fos.close()
        }catch (e: Exception){
            Log.d("Exception3", e.message.toString())
        }
    }

    public fun ReadDataFromFile(fis: FileInputStream) : HashMap<String, Any>? {

        try {
            var ois = ObjectInputStream(fis)
            val mapInFile = ois.readObject() as HashMap<String, Any>

            ois.close()
            fis.close()
            return mapInFile
        }catch (e: Exception){
            Log.d("Exception4", e.message.toString())
            return null
        }
    }
}