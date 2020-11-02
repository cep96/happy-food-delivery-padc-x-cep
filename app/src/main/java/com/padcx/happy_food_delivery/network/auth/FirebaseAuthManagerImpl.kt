package com.padcx.happy_food_delivery.network.auth

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest

object FirebaseAuthManagerImpl: AuthManager {

    private val mFirebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firebaseUser = mFirebaseAuth.currentUser

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

    override fun getUserName(): String {
        return mFirebaseAuth.currentUser?.displayName ?: ""
    }

    override fun getUserEmail(): String {
        return mFirebaseAuth.currentUser?.email ?: ""
    }

    override fun getUserPhone(): String {
        return mFirebaseAuth.currentUser?.phoneNumber ?: ""
    }

    override fun updateProfile(
        email: String,
        changeRequest: UserProfileChangeRequest,
        onSuccess: (FirebaseUser) -> Unit,
        onFailure: (String) -> Unit
    ) {
        if (email != mFirebaseAuth.currentUser?.email){
            mFirebaseAuth.currentUser?.updateEmail(email)?.addOnCompleteListener {
                if(it.isSuccessful && it.isComplete) Log.d("emailUpdate","Success")
                else it.exception?.localizedMessage?.let { it1 -> Log.d("emailUpdate", it1) }
            }
        }

        firebaseUser?.updateProfile(changeRequest)?.addOnCompleteListener {task ->
            if (task.isSuccessful){
                Log.d("Profile", "==> Profile updated")
            }
        }
    }

}