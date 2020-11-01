package com.padcx.happy_food_delivery.delegates

interface FoodItemActionDelegate {

    fun onTapFoodItem(name: String, count: Int, price: Int)

}