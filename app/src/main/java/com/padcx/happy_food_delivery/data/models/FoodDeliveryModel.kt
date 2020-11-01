package com.padcx.happy_food_delivery.data.models

import com.padcx.happy_food_delivery.data.vos.*
import com.padcx.happy_food_delivery.network.FirebaseApi
import com.padcx.happy_food_delivery.network.remoteconfig.FirebaseRemoteConfigManager

interface FoodDeliveryModel {

    var mFirebaseApi: FirebaseApi
    var mRemoteConfig: FirebaseRemoteConfigManager

    fun getRestaurants(onSuccess: (restaurants: List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit)
    fun getFoodCategories(onSuccess: (categories: List<FoodVO>) -> Unit, onFailure: (String) -> Unit)
    fun getPopularChoices(onSuccess: (popularChoices: List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit)
    fun getNewRestaurants(onSuccess: (newRestaurants: List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit)

    fun getFoodItems(restaurantId: String, onSuccess: (foodItems: List<FoodItemVO>) -> Unit, onFailure: (String) -> Unit)
    fun getPopularFood(restaurantId: String, onSuccess: (popularFoods: List<PopularChoiceVO>) -> Unit, onFailure: (String) -> Unit)

    fun setUpRemoteConfigWithDefaultValues()
    fun fetchRemoteConfig()
    fun getRemoteConfigViewType(): Int

    fun addFoodOrder(name: String, count: Int, price: Int, origin_price: Int)
    fun getFoodFromBasket(onSuccess: (List<MyOrderVO>) -> Unit, onFailure: (String) -> Unit)
    fun removeFood(name: String)
    fun deleteAllFood()
}