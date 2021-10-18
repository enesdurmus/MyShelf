package com.example.myshelf

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.*

/**
 *
 * @author enesdurmus
 */

class InternalStorageHandler() : AppCompatActivity() {

    fun WriteDataToFile(fileName : String, data: Any){
        try {
            var fos = AppClass.context?.openFileOutput(fileName, Context.MODE_PRIVATE)
            var ous = ObjectOutputStream(fos)
            ous.writeObject(data)
            ous.close()
            fos?.close()
        }catch (e: Exception){
            Log.d("Exception3", e.message.toString())
        }
    }

    fun ReadDataFromFile(fileName: String) : HashMap<String, Any>? {

        try {
            var fis = AppClass.context?.openFileInput(fileName)
            var ois = ObjectInputStream(fis)
            val mapInFile = ois.readObject() as HashMap<String, Any>

            ois.close()
            fis?.close()
            return mapInFile
        }catch (e: Exception){
            Log.d("Exception4", e.message.toString())
            return null
        }
    }
}