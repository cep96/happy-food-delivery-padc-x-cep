package com.padcx.happy_food_delivery.delegates

import com.padcx.happy_food_delivery.data.vos.RestaurantVO

interface RestaurantActionDelegate {

    fun onTapRestaurant(restaurant: RestaurantVO)

}