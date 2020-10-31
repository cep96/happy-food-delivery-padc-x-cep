package com.padcx.happy_food_delivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.data.vos.FoodVO
import com.padcx.happy_food_delivery.views.viewholders.FoodCategoryViewHolder

class FoodCategoryRecyclerAdapter: BaseAdapter<FoodCategoryViewHolder, FoodVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodCategoryViewHolder {
        return FoodCategoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category, parent, false)
        )
    }
}