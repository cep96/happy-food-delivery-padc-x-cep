package com.padcx.happy_food_delivery.data.models

import com.padcx.happy_food_delivery.data.vos.FoodVO
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import com.padcx.happy_food_delivery.network.CloudFirestoreFirebaseApiImpl
import com.padcx.happy_food_delivery.network.FirebaseApi

object FoodDeliveryModelImpl: FoodDeliveryModel {

    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl

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
}