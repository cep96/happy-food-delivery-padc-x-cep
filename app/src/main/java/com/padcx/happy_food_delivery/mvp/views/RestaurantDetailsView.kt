package com.padcx.happy_food_delivery.mvp.views

import com.padcx.happy_food_delivery.data.vos.FoodItemVO
import com.padcx.happy_food_delivery.data.vos.PopularChoiceVO
import com.padcx.happy_food_delivery.data.vos.RestaurantVO

interface RestaurantDetailsView: BaseView {

    fun showDetails(restaurant: RestaurantVO)
    fun showPopularChoicesItem(itemFood: List<PopularChoiceVO>)
    fun showFoodItems(itemFood: List<FoodItemVO>)

    fun navigateToOrderScreen(name: String, count: Int, price: Int)
}