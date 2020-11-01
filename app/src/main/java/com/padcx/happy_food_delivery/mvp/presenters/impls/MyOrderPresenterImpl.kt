package com.padcx.happy_food_delivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.happy_food_delivery.data.models.FoodDeliveryModelImpl
import com.padcx.happy_food_delivery.data.vos.MyOrderVO
import com.padcx.happy_food_delivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happy_food_delivery.mvp.presenters.MyOrderPresenter
import com.padcx.happy_food_delivery.mvp.views.MyOrderView

class MyOrderPresenterImpl : MyOrderPresenter, AbstractBasePresenter<MyOrderView>() {

    private val mFoodDeliveryModel = FoodDeliveryModelImpl

    override fun onUIReady(owner: LifecycleOwner, name: String, count: Int, price: Int) {
        mFoodDeliveryModel.addFoodOrder(name, count, price, price)

        mFoodDeliveryModel.getFoodFromBasket(onSuccess = {
            mView.showOrders(it)
        }, onFailure = {
            mView.showError(it)
        })
    }

    override fun onTapCheckOut(orderList: List<MyOrderVO>) {
        for (order in orderList) {
            mFoodDeliveryModel.removeFood(order.name!!)
        }
        mView.showCheckOutBottomSheet()
    }

    override fun onTapBtnRemove(name: String, count: Int, price: Int, originPrice: Int) {
        if (count == 0) {
            mFoodDeliveryModel.removeFood(name)
        } else {
            mFoodDeliveryModel.addFoodOrder(name, count, price, originPrice)
        }
    }

    override fun onTapBtnAdd(name: String, count: Int, price: Int, originPrice: Int) {
        mFoodDeliveryModel.addFoodOrder(name, count, price, originPrice)
    }

}