package com.padcx.happy_food_delivery.mvp.presenters.impls

import com.padcx.happy_food_delivery.data.models.AuthenticationModel
import com.padcx.happy_food_delivery.data.models.AuthenticationModelImpl
import com.padcx.happy_food_delivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happy_food_delivery.mvp.presenters.SignUpPresenter
import com.padcx.happy_food_delivery.mvp.views.SignUpView

class SignUpPresenterImpl: SignUpPresenter, AbstractBasePresenter<SignUpView>() {

    private val mAuthenticationModelImpl: AuthenticationModel = AuthenticationModelImpl

    override fun onTapBtnSignUp(
        email: String,
        password: String,
        userName: String,
        userPhone: String
    ) {
        mAuthenticationModelImpl.register(email, password, userName, userPhone, onSuccess = {
            mView.navigateToLoginScreen()
        }, onFailure = {
            mView.showError(it)
        })
    }

    override fun onTapBtnLogin() {
        mView.navigateToLoginScreen()
    }
}