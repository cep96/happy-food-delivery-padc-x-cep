package com.padcx.happy_food_delivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import com.padcx.happy_food_delivery.views.viewholders.PopularChoiceViewHolder

class PopularChoiceRecyclerAdapter: BaseAdapter<PopularChoiceViewHolder, RestaurantVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularChoiceViewHolder {
        return PopularChoiceViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_popular_choices, parent, false)
        )
    }
}