package com.padcx.happy_food_delivery.mvp.presenters

import com.padcx.happy_food_delivery.mvp.views.StartView

interface StartPresenter: BasePresenter<StartView> {

    fun onTapGetStarted()
}