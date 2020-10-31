package com.padcx.happy_food_delivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happy_food_delivery.mvp.views.MainView

interface MainPresenter: BasePresenter<MainView> {

    fun onUIReady(owner: LifecycleOwner)

}