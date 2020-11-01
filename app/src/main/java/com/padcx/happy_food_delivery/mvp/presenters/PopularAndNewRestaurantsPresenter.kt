package com.padcx.happy_food_delivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import com.padcx.happy_food_delivery.delegates.RestaurantActionDelegate
import com.padcx.happy_food_delivery.mvp.views.PopularAndNewRestaurantsView

interface PopularAndNewRestaurantsPresenter: BasePresenter<PopularAndNewRestaurantsView>,
    RestaurantActionDelegate {

    fun onUIReady(owner: LifecycleOwner)
}