package com.example.freelancer.signin

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignInViewModel(app: Application) : AndroidViewModel(app) {

    val auth = FirebaseAuth.getInstance()
    val db = Firebase.firestore

    val user = auth.currentUser?.let { FirebaseAuth.getInstance().updateCurrentUser(it) }
    private val _toastMessage = MutableLiveData<String>()
    val toastMessage:LiveData<String>
    get() = _toastMessage

    private val _isAuthenticated = MutableLiveData<Boolean>()
    val isAuthenticated: LiveData<Boolean>
    get() = _isAuthenticated

    val signUpFirstName = MutableLiveData<String>()
    val signUpLastName = MutableLiveData<String>()
    val signUpEmail = MutableLiveData<String>()
    val signUpPassword = MutableLiveData<String>()

    init {
        _isAuthenticated.value = isAuthenticated()
    }
fun createAccount(){
    signUp(signUpEmail.value.toString(),signUpPassword.value.toString())
}
    fun signIn(){
        signIn(signUpEmail.value.toString(),signUpPassword.value.toString())
    }
   private fun signUp(email: String,password: String){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    saveUserName(signUpFirstName.value.toString(),signUpLastName.value.toString())
                    _toastMessage.value = "Successful"
                    _isAuthenticated.value = true
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    _toastMessage.value = "Failure"
                }
            }
    }

    private fun signIn(email: String,password: String){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener{task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "signInWithEmail:success")
                _toastMessage.value = "Successful"
                _isAuthenticated.value = true
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithEmail:failure", task.exception)
                _toastMessage.value = task.exception?.message
            }
        }
    }

   private fun saveUserName(firstName: String,lastName: String){

        // Create a new user with a first and last name
        val user = hashMapOf(
            "firstName" to firstName,
            "lastName" to lastName
        )

// Add a new document with a generated ID
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }

    private fun isAuthenticated():Boolean{
        return auth.currentUser != null
    }
}
