package com.padcx.happy_food_delivery.data.models

import com.padcx.happy_food_delivery.data.vos.FoodVO
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import com.padcx.happy_food_delivery.network.FirebaseApi

interface FoodDeliveryModel {

    var mFirebaseApi: FirebaseApi

    fun getRestaurants(onSuccess: (restaurants: List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit)
    fun getFoodCategories(onSuccess: (categories: List<FoodVO>) -> Unit, onFailure: (String) -> Unit)
}