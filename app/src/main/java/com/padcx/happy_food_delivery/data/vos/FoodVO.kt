package com.padcx.happy_food_delivery.data.vos

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class FoodVO(
    var image: String ?= "",
    var type: String ?= "",
    var id: Int = 0
)