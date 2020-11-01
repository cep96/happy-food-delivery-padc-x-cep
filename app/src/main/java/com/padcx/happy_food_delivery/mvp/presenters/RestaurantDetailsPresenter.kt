package com.padcx.happy_food_delivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happy_food_delivery.data.vos.FoodItemVO
import com.padcx.happy_food_delivery.data.vos.PopularChoiceVO
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import com.padcx.happy_food_delivery.delegates.FoodItemActionDelegate
import com.padcx.happy_food_delivery.mvp.views.RestaurantDetailsView

interface RestaurantDetailsPresenter: BasePresenter<RestaurantDetailsView>, FoodItemActionDelegate {

    fun onUIReady(owner: LifecycleOwner, restaurant: RestaurantVO)
    fun getPopularChoices(restaurantId: String, foodItems: List<PopularChoiceVO>)
    fun getFoodItems(restaurantId: String, foodItems: List<FoodItemVO>)
}