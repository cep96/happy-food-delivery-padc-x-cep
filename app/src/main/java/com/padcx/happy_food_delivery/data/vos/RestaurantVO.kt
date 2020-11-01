package com.padcx.happy_food_delivery.data.vos

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class RestaurantVO(
    var id: String ?= "",
    var name: String ?= "",
    var type: String ?= "",
    var rating: Double ?= 0.0,
    var image: String ?= "",
    var location: String ?= "",
    var estimate_time: String = "",
    var menu: List<FoodItemVO> = arrayListOf(),
    var popular_choices: List<PopularChoiceVO> = arrayListOf()
): Serializable