package com.padcx.happy_food_delivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.data.vos.FoodItemVO
import com.padcx.happy_food_delivery.delegates.FoodItemActionDelegate
import com.padcx.happy_food_delivery.views.viewholders.FoodItemViewHolder

class FoodItemRecyclerAdapter(private val delegate: FoodItemActionDelegate): BaseAdapter<FoodItemViewHolder, FoodItemVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemViewHolder {
        return FoodItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_food, parent, false),
            delegate
        )
    }
}