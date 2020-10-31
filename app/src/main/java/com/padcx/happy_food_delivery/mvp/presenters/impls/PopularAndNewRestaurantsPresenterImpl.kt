package com.padcx.happy_food_delivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.happy_food_delivery.data.models.FoodDeliveryModel
import com.padcx.happy_food_delivery.data.models.FoodDeliveryModelImpl
import com.padcx.happy_food_delivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happy_food_delivery.mvp.presenters.PopularAndNewRestaurantsPresenter
import com.padcx.happy_food_delivery.mvp.views.PopularAndNewRestaurantsView

class PopularAndNewRestaurantsPresenterImpl: PopularAndNewRestaurantsPresenter,
    AbstractBasePresenter<PopularAndNewRestaurantsView>() {

    private val mFoodDeliveryModel: FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onUIReady(owner: LifecycleOwner) {
        mFoodDeliveryModel.getPopularChoices(onSuccess = {
            mView.showPopularChoices(it)
        }, onFailure = {
            mView.showError(it)
        })

        mFoodDeliveryModel.getNewRestaurants(onSuccess = {
            mView.showNewRestaurants(it)
        }, onFailure = {
            mView.showError(it)
        })
    }
}