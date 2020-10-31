package com.padcx.happy_food_delivery.data.models

import com.padcx.happy_food_delivery.data.vos.FoodVO
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
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

    override fun setUpRemoteConfigWithDefaultValues() {
        mRemoteConfig.setUpRemoteConfigWithDefaultValuer()
    }

    override fun fetchRemoteConfig() {
        mRemoteConfig.fetchRemoteConfig()
    }

    override fun getRemoteConfigViewType(): Int {
        return mRemoteConfig.getViewType()
    }
}