package com.padcx.happy_food_delivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.happy_food_delivery.data.models.FoodDeliveryModel
import com.padcx.happy_food_delivery.data.models.FoodDeliveryModelImpl
import com.padcx.happy_food_delivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happy_food_delivery.mvp.presenters.RestaurantsPresenter
import com.padcx.happy_food_delivery.mvp.views.RestaurantsView

class RestaurantsPresenterImpl: RestaurantsPresenter, AbstractBasePresenter<RestaurantsView>() {

    private val mFoodDeliveryModel: FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onUIReady(owner: LifecycleOwner) {
        mFoodDeliveryModel.getRestaurants(onSuccess = {
            mView.showRestaurants(it)
        }, onFailure = {
            mView.showError(it)
        })

        mFoodDeliveryModel.getFoodCategories(onSuccess = {
            mView.showCategories(it)
        }, onFailure = {
            mView.showError(it)
        })
    }
}