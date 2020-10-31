package com.padcx.happy_food_delivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happy_food_delivery.mvp.views.PopularAndNewRestaurantsView

interface PopularAndNewRestaurantsPresenter: BasePresenter<PopularAndNewRestaurantsView> {

    fun onUIReady(owner: LifecycleOwner)
}