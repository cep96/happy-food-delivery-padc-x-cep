package com.padcx.happy_food_delivery.mvp.presenters.impls

import com.padcx.happy_food_delivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happy_food_delivery.mvp.presenters.SignUpPresenter
import com.padcx.happy_food_delivery.mvp.views.SignUpView

class SignUpPresenterImpl: SignUpPresenter, AbstractBasePresenter<SignUpView>() {
    override fun onTapBtnSignUp() {
        mView.navigateToLoginScreen()
    }

    override fun onTapBtnLogin() {
        mView.navigateToLoginScreen()
    }
}