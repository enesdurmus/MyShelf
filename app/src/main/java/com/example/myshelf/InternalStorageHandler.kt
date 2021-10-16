package com.example.myshelf

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import java.io.*

/**
 *
 * @author enesdurmus
 */

class InternalStorageHandler(debeme : EditText) : AppCompatActivity() {

    private lateinit var fos : FileOutputStream
    private lateinit var fis : FileInputStream
    private val texttt : EditText

    private var sea : String = "aloooooooooooooooooooooo"

    init {
        texttt = debeme
    }

    public fun WriteDataToFile(data : ByteArray){
        print("aloooo")
        /*try {
            fos = openFileOutput("example.txt", Context.MODE_PRIVATE)
            fos.write(data)
        }catch (e : FileNotFoundException){
            print("file not found.")
        }
        catch (e : IOException){
            print("io exception.")
        }
*/
    }

    public fun ReadDataFromFile(){
        fis = openFileInput("example.txt")
        var isr : InputStreamReader = InputStreamReader(fis)
        val br: BufferedReader = BufferedReader(isr)
        val sb : StringBuilder = StringBuilder()
        var text: String? = null

        while ({ text = br.readLine(); text }() != null) {
            sb.append(text)
        }

        //texttt.setText(sb.toString()).toString()
    }
}