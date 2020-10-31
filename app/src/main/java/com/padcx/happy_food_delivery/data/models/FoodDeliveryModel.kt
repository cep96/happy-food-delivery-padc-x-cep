package com.padcx.happy_food_delivery.data.models

import com.padcx.happy_food_delivery.data.vos.FoodVO
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import com.padcx.happy_food_delivery.network.FirebaseApi
import com.padcx.happy_food_delivery.network.remoteconfig.FirebaseRemoteConfigManager

interface FoodDeliveryModel {

    var mFirebaseApi: FirebaseApi
    var mRemoteConfig: FirebaseRemoteConfigManager

    fun getRestaurants(onSuccess: (restaurants: List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit)
    fun getFoodCategories(onSuccess: (categories: List<FoodVO>) -> Unit, onFailure: (String) -> Unit)
    fun getPopularChoices(onSuccess: (popularChoices: List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit)
    fun getNewRestaurants(onSuccess: (newRestaurants: List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit)

    fun setUpRemoteConfigWithDefaultValues()
    fun fetchRemoteConfig()
    fun getRemoteConfigViewType(): Int
}