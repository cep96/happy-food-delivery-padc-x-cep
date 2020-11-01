package com.padcx.happy_food_delivery.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.happy_food_delivery.data.vos.PopularChoiceVO
import com.padcx.happy_food_delivery.delegates.FoodItemActionDelegate
import kotlinx.android.synthetic.main.item_food_popular_choices.view.*

class FoodItemPopularChoicesViewHolder(
    itemView: View, private val delegate: FoodItemActionDelegate)
    : BaseViewHolder<PopularChoiceVO>(itemView) {
    override fun bindData(data: PopularChoiceVO) {
        itemView.tvFoodName.text = data.name
        itemView.tvFoodPrice.text = "$${data.price}"

        Glide.with(itemView)
            .load(data.image)
            .into(itemView.ivFoodImg)

        itemView.setOnClickListener {
            delegate.onTapFoodItem(data.name!!, 1, data.price!! )
        }
    }
}