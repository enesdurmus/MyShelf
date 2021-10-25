package com.example.myshelf

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.*
import androidx.annotation.NonNull

import com.google.android.gms.tasks.OnFailureListener

import com.google.firebase.firestore.DocumentReference

import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query


/**
 *
 * @author enesdurmus
 */

class StorageHandler(firebaseDocumentId : String) : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()
    private var _fireBaseDocumentId : String

    init {
        _fireBaseDocumentId = firebaseDocumentId
    }

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

    fun ReadDataFromFirebase() {
        val docRef = db.collection("users").document("r93pe2oHmRSi58hH7EOS")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("1", "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d("2", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("3", "get failed with ", exception)
            }
    }

    fun ReadDataFromFirebase(userName : String){
        db.collection("users")
            .whereEqualTo("UserName", userName)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    Log.d("1", "${document.id} => ${document.data}")
                    MainActivity.OnUserReadSuccesfull()
                }
            }
            .addOnFailureListener { exception ->
                Log.w("2", "Error getting documents: ", exception)
            }
    }

    fun WriteDataToFirebase(user : HashMap<String, Any>){
        db.collection("users")
            .add(user)
            .addOnSuccessListener(OnSuccessListener<DocumentReference> { documentReference ->
                Log.d(
                    "WriteFirebaseSuccess",
                    "DocumentSnapshot added with ID: " + documentReference.id
                )
            })
            .addOnFailureListener(OnFailureListener { e ->
                Log.w(
                    "WriteFirebaseFail", "Error adding document", e) })
    }
}