package com.padcx.happy_food_delivery.data.models

import com.padcx.happy_food_delivery.data.vos.*
import com.padcx.happy_food_delivery.network.CloudFirestoreFirebaseApiImpl
import com.padcx.happy_food_delivery.network.FirebaseApi
import com.padcx.happy_food_delivery.network.remoteconfig.FirebaseRemoteConfigManager

object FoodDeliveryModelImpl: FoodDeliveryModel {

    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl
    override var mRemoteConfig: FirebaseRemoteConfigManager = FirebaseRemoteConfigManager

    override fun getRestaurants(
        onSuccess: (restaurants: List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getRestaurants(onSuccess, onFailure)
    }

    override fun getFoodCategories(
        onSuccess: (categories: List<FoodVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getFoodCategories(onSuccess, onFailure)
    }

    override fun getPopularChoices(
        onSuccess: (popularChoices: List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getPopularChoices(onSuccess, onFailure)
    }

    override fun getNewRestaurants(
        onSuccess: (newRestaurants: List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getNewRestaurants(onSuccess, onFailure)
    }

    override fun getFoodItems(
        restaurantId: String,
        onSuccess: (foodItems: List<FoodItemVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getFoodItems(restaurantId, onSuccess, onFailure)
    }

    override fun getPopularFood(
        restaurantId: String,
        onSuccess: (popularFoods: List<PopularChoiceVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getPopularFoodItems(restaurantId, onSuccess, onFailure)
    }

    override fun setUpRemoteConfigWithDefaultValues() {
        mRemoteConfig.setUpRemoteConfigWithDefaultValuer()
    }

    override fun fetchRemoteConfig() {
        mRemoteConfig.fetchRemoteConfig()
    }

    override fun getRemoteConfigViewType(): Int {
        return mRemoteConfig.getViewType()
    }

    override fun addFoodOrder(name: String, count: Int, price: Int, origin_price: Int) {
        mFirebaseApi.addFoodToBasket(name, count, price, origin_price)
    }

    override fun getFoodFromBasket(
        onSuccess: (List<MyOrderVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getFoodsOrderFromBasket(onSuccess, onFailure)
    }

    override fun removeFood(name: String) {
        mFirebaseApi.deleteFoodFromBasket(name)
    }

    override fun deleteAllFood() {
        mFirebaseApi.deleteAllFoodInBasket()
    }


}