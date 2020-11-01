package com.padcx.happy_food_delivery.data.vos

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class FoodItemVO(
    var image: String ?= "",
    var isPopular: Boolean = false,
    var price: Int = 0,
    var name: String ?= "",
    var ingredients: List<String> = arrayListOf()
): Serializable