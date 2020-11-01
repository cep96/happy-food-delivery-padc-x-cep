package com.padcx.happy_food_delivery.mvp.views

interface AccountView: BaseView {

    fun showUserInfo(userName: String, userEmail: String, userPhone: String, userProfile: String)
    fun openGallery()
}