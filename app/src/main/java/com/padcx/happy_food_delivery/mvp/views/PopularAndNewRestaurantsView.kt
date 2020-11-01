package com.padcx.happy_food_delivery.mvp.views

import com.padcx.happy_food_delivery.data.vos.RestaurantVO

interface PopularAndNewRestaurantsView: BaseView {

    fun showNewRestaurants(newRestaurants: List<RestaurantVO>)
    fun showPopularChoices(popularChoices: List<RestaurantVO>)

    fun navigateToDetailsScreen(restaurantVO: RestaurantVO)

}