package com.padcx.happy_food_delivery.mvp.views

import com.padcx.happy_food_delivery.data.vos.FoodVO
import com.padcx.happy_food_delivery.data.vos.RestaurantVO

interface RestaurantsView: BaseView {

    fun showCategories(categories: List<FoodVO>)
    fun showRestaurants(restaurants: List<RestaurantVO>)

}