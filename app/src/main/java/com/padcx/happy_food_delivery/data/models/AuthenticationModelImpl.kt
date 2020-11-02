package com.padcx.happy_food_delivery.data.models

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.padcx.happy_food_delivery.network.auth.AuthManager
import com.padcx.happy_food_delivery.network.auth.FirebaseAuthManagerImpl

object AuthenticationModelImpl: AuthenticationModel {

    override var mAuthManager: AuthManager = FirebaseAuthManagerImpl

    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.login(email, password, onSuccess, onFailure)
    }

    override fun register(
        email: String,
        password: String,
        useName: String,
        userPhone: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.register(email, password, useName, userPhone, onSuccess, onFailure)
    }

    override fun updateProfile(
        email: String,
        changeRequest: UserProfileChangeRequest,
        onSuccess: (FirebaseUser) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.updateProfile(email, changeRequest, onSuccess, onFailure)
    }

    override fun getUserName(): String {
        return mAuthManager.getUserName()
    }

    override fun getUserEmail(): String {
        return mAuthManager.getUserEmail()
    }

    override fun getUserPhone(): String {
        return mAuthManager.getUserPhone()
    }
}