package com.padcx.happy_food_delivery.data.models

import com.padcx.happy_food_delivery.network.auth.AuthManager

interface AuthenticationModel {

    var mAuthManager: AuthManager

    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)

    fun register(email: String, password: String, useName: String, userPhone: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)

}