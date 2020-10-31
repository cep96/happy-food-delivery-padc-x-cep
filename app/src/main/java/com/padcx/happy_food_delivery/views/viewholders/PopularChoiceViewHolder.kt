package com.padcx.happy_food_delivery.views.viewholders

import android.view.View
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import kotlinx.android.synthetic.main.item_popular_choices.view.*

class PopularChoiceViewHolder(itemView: View) : BaseViewHolder<RestaurantVO>(itemView) {
    override fun bindData(data: RestaurantVO) {
        itemView.tvRestaurantName.text = data.name
        itemView.tvRestaurantType.text = data.type
        itemView.tvRating.text = data.rating.toString()
    }
}