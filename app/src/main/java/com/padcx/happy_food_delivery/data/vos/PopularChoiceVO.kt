package com.padcx.happy_food_delivery.data.vos

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class PopularChoiceVO(
    var image: String ?= "",
    var name: String ?= "",
    var price: Int ?= 0
): Serializable