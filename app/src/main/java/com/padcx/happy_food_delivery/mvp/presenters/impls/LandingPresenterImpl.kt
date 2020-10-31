package com.padcx.happy_food_delivery.mvp.presenters.impls

import com.padcx.happy_food_delivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happy_food_delivery.mvp.presenters.LandingPresenter
import com.padcx.happy_food_delivery.mvp.views.LandingView

class LandingPresenterImpl : LandingPresenter, AbstractBasePresenter<LandingView>() {
    override fun onTapLogin() {
        mView.navigateToLoginScreen()
    }

    override fun onTapCreateAccount() {
        mView.navigateToCreateAccountScreen()
    }

    override fun onTapFacebookAccount() {
        TODO("Not yet implemented")
    }
}