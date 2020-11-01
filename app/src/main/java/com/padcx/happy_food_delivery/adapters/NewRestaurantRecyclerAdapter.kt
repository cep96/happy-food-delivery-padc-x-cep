package com.padcx.happy_food_delivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import com.padcx.happy_food_delivery.delegates.RestaurantActionDelegate
import com.padcx.happy_food_delivery.views.viewholders.NewRestaurantViewHolder

class NewRestaurantRecyclerAdapter(private val delegate: RestaurantActionDelegate): BaseAdapter<NewRestaurantViewHolder, RestaurantVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewRestaurantViewHolder {
        return NewRestaurantViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_new_restaurant, parent, false),
            delegate
        )
    }
}