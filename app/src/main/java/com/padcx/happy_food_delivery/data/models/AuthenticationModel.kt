package com.padcx.happy_food_delivery.data.models

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.padcx.happy_food_delivery.network.auth.AuthManager

interface AuthenticationModel {

    var mAuthManager: AuthManager

    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun register(email: String, password: String, useName: String, userPhone: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun updateProfile(email: String, changeRequest: UserProfileChangeRequest, onSuccess: (FirebaseUser) -> Unit, onFailure: (String) -> Unit)

    fun getUserName(): String
    fun getUserEmail(): String
    fun getUserPhone(): String
}