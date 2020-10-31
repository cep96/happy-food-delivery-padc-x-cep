package com.padcx.happy_food_delivery.data.vos

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class RestaurantVO(
    var name: String ?= "",
    var type: String ?= "",
    var rating: Double ?= 0.0,
    var image: String ?= "",
    var location: String ?= "",
    var estimate_time: String = "",
    var menu: ArrayList<MenuVO> = arrayListOf(),
    var popular_choices: ArrayList<PopularChoiceVO> = arrayListOf()
)