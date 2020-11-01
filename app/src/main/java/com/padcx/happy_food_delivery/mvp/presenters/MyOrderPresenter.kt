package com.padcx.happy_food_delivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happy_food_delivery.data.vos.MyOrderVO
import com.padcx.happy_food_delivery.delegates.OrderItemActionDelegate
import com.padcx.happy_food_delivery.mvp.views.MyOrderView

interface MyOrderPresenter: BasePresenter<MyOrderView>, OrderItemActionDelegate {

    fun onUIReady(owner: LifecycleOwner, name: String, count: Int, price: Int)
    fun onTapCheckOut(orderList: List<MyOrderVO>)
}