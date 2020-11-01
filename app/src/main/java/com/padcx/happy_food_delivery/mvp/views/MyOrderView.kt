package com.padcx.happy_food_delivery.mvp.views

import com.padcx.happy_food_delivery.data.vos.MyOrderVO

interface MyOrderView: BaseView {

    fun showOrders(orders: List<MyOrderVO>)
    fun showCheckOutBottomSheet()

}