package com.padcx.happy_food_delivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import com.padcx.happy_food_delivery.views.viewholders.RestaurantViewHolder

class RestaurantRecyclerAdapter: BaseAdapter<RestaurantViewHolder, RestaurantVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_restaurant, parent, false)
        )
    }
}