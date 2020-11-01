package com.padcx.happy_food_delivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.data.vos.PopularChoiceVO
import com.padcx.happy_food_delivery.delegates.FoodItemActionDelegate
import com.padcx.happy_food_delivery.views.viewholders.FoodItemPopularChoicesViewHolder

class FoodItemPopularChoiceRecyclerAdapter(private val delegate: FoodItemActionDelegate):
    BaseAdapter<FoodItemPopularChoicesViewHolder, PopularChoiceVO>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodItemPopularChoicesViewHolder {
        return FoodItemPopularChoicesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_food_popular_choices, parent, false),
            delegate
        )
    }
}