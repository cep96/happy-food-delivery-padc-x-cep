package com.padcx.happy_food_delivery.network.auth

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest

interface AuthManager {

    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun register(email: String, password: String, userName: String, userPhone: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun getUserName(): String
    fun getUserEmail(): String
    fun getUserPhone(): String

    fun updateProfile(email: String, changeRequest: UserProfileChangeRequest, onSuccess: (FirebaseUser) -> Unit, onFailure: (String) -> Unit)
}
