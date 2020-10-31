package com.padcx.happy_food_delivery.data.vos

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class MenuVO(
    var isPopular: Boolean = false,
    var name: String ?= "",
    var price: String ?= "",
    var image: String ?= "",
    var ingredients: ArrayList<String> = arrayListOf()
)