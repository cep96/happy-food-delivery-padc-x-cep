package com.padcx.happy_food_delivery.network.auth

interface AuthManager {

    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun register(email: String, password: String, userName: String, userPhone: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun getUserName(): String
    fun getUserEmail(): String
    fun getUserPhone(): String

    fun updateProfile(name: String, profileUrl: String)
}
