package com.padcx.happy_food_delivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happy_food_delivery.mvp.views.RestaurantsView

interface RestaurantsPresenter: BasePresenter<RestaurantsView> {

    fun onUIReady(owner: LifecycleOwner)
}