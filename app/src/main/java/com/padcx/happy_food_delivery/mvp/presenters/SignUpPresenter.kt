package com.padcx.happy_food_delivery.mvp.presenters

import com.padcx.happy_food_delivery.mvp.views.SignUpView

interface SignUpPresenter: BasePresenter<SignUpView> {

    fun onTapBtnSignUp(email: String, password: String, userName: String, userPhone: String)
    fun onTapBtnLogin()

}