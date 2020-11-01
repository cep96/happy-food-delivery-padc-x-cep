package com.padcx.happy_food_delivery.network

import com.padcx.happy_food_delivery.data.vos.*

interface FirebaseApi {

    fun getRestaurants(onSuccess: (restaurants: List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit)
    fun getFoodCategories(onSuccess: (categories: List<FoodVO>) -> Unit, onFailure: (String) -> Unit)
    fun getPopularChoices(onSuccess: (popularChoices: List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit)
    fun getNewRestaurants(onSuccess: (newsRestaurants: List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit)

    fun getFoodsOrderFromBasket(onSuccess: (orders: List<MyOrderVO>) -> Unit, onFailure: (String) -> Unit)
    fun addFoodToBasket(name: String, price: Int, count: Int, origin_price: Int)
    fun deleteFoodFromBasket(name: String)
    fun deleteAllFoodInBasket()

    fun getFoodItems(documentId: String, onSuccess: (foodItems: List<FoodItemVO>) -> Unit, onFailure: (String) -> Unit)
    fun getPopularFoodItems(documentId: String, onSuccess: (foodItems: List<PopularChoiceVO>) -> Unit, onFailure: (String) -> Unit)

}