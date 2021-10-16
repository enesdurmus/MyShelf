package com.example.myshelf

import android.content.Context
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

    public fun WriteDataToFile(data : ByteArray, fos : FileOutputStream){
        try {
            fos.write(data)
        }catch (e: Exception){
            _texttt.setText("hata")
        }
    }

    public fun ReadDataFromFile(fis: FileInputStream){
        var isr : InputStreamReader = InputStreamReader(fis)
        val br: BufferedReader = BufferedReader(isr)
        val sb : StringBuilder = StringBuilder()
        var text: String? = null

        while ({ text = br.readLine(); text }() != null) {
            sb.append(text)
        }

        _texttt.setText(sb.toString()).toString()
    }
}