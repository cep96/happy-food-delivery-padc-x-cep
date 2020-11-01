package com.padcx.happy_food_delivery.delegates

interface OrderItemActionDelegate {

    fun onTapBtnRemove(name: String, count: Int, price: Int, originPrice: Int)
    fun onTapBtnAdd(name: String, count:Int, price: Int, originPrice: Int)
}