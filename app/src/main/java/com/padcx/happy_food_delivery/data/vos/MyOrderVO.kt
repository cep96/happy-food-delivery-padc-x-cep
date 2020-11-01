package com.padcx.happy_food_delivery.data.vos

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class MyOrderVO (
    var id: Int = 0,
    var name: String ?= "",
    var price: Int = 0,
    var count: Int = 0,
    var origin_price: Int = 0
)