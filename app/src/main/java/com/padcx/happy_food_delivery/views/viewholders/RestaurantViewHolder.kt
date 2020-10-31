package com.padcx.happy_food_delivery.views.viewholders

import android.view.View
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import kotlinx.android.synthetic.main.item_restaurant.view.*

class RestaurantViewHolder(itemView: View) : BaseViewHolder<RestaurantVO>(itemView) {

    override fun bindData(data: RestaurantVO) {
       itemView.tvRestaurantName.text = data.name
        itemView.tvRating.text = data.rating.toString()
        itemView.tvRatingNCategory.text = data.type
    }
}