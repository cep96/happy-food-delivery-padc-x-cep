package com.padcx.happy_food_delivery.mvp.presenters.impls

import com.padcx.happy_food_delivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happy_food_delivery.mvp.presenters.StartPresenter
import com.padcx.happy_food_delivery.mvp.views.StartView

class StartPresenterImpl: StartPresenter, AbstractBasePresenter<StartView>() {

    override fun onTapGetStarted() {
        mView.navigateToLandingScreen()
    }
}