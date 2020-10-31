package com.padcx.happy_food_delivery.mvp.presenters

import com.padcx.happy_food_delivery.mvp.views.LandingView

interface LandingPresenter: BasePresenter<LandingView> {

    fun onTapLogin()
    fun onTapCreateAccount()
    fun onTapFacebookAccount()
}