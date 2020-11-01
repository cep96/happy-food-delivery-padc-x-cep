package com.padcx.happy_food_delivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.happy_food_delivery.data.models.FoodDeliveryModelImpl
import com.padcx.happy_food_delivery.data.vos.FoodItemVO
import com.padcx.happy_food_delivery.data.vos.PopularChoiceVO
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import com.padcx.happy_food_delivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happy_food_delivery.mvp.presenters.RestaurantDetailsPresenter
import com.padcx.happy_food_delivery.mvp.views.RestaurantDetailsView

class RestaurantDetailsPresenterImpl: RestaurantDetailsPresenter,
    AbstractBasePresenter<RestaurantDetailsView>() {

    private val mFoodDeliveryModel = FoodDeliveryModelImpl

    override fun onUIReady(owner: LifecycleOwner, restaurant: RestaurantVO) {
       mView.showDetails(restaurant)
    }

    override fun getPopularChoices(restaurantId: String,foodItems: List<PopularChoiceVO>) {
        mFoodDeliveryModel.getPopularFood(restaurantId, onSuccess ={
            mView.showPopularChoicesItem(it)
        },onFailure = {
            mView.showError(it)
        })
    }

    override fun getFoodItems(restaurantId: String, foodItems: List<FoodItemVO>) {
        mFoodDeliveryModel.getFoodItems(restaurantId, onSuccess = {
            mView.showFoodItems(it)
        }, onFailure = {
            mView.showError(it)
        })
    }

    override fun onTapFoodItem(name: String, count: Int, price: Int) {
        mView.navigateToOrderScreen(name, count, price)
    }
}