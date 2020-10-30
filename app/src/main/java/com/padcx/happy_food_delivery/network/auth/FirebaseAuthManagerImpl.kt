package com.padcx.happy_food_delivery.network.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

object FirebaseAuthManagerImpl: AuthManager {

    private val mFirebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {task ->
            if (task.isSuccessful && task.isComplete){
                onSuccess()
            }else{
                onFailure(task.exception?.localizedMessage ?: "Please check internet connection")
            }
        }
    }

    override fun register(
        email: String,
        password: String,
        userName: String,
        userPhone: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {task ->
            if (task.isSuccessful && task.isComplete){
                mFirebaseAuth.currentUser?.updateProfile(
                    UserProfileChangeRequest.Builder()
                        .setDisplayName(userName)
                        .build()
                )
                onSuccess()
            }else{
                onFailure(task.exception?.message ?: "Please check internet connection")
            }
        }
    }
}