package com.padcx.happy_food_delivery.network

import com.padcx.happy_food_delivery.data.vos.FoodVO
import com.padcx.happy_food_delivery.data.vos.RestaurantVO

interface FirebaseApi {

    fun getRestaurants(onSuccess: (restaurants: List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit)

    fun getFoodCategories(onSuccess: (categories: List<FoodVO>) -> Unit, onFailure: (String) -> Unit)

}