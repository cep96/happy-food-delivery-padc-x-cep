package com.padcx.happy_food_delivery.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import com.padcx.happy_food_delivery.delegates.RestaurantActionDelegate
import kotlinx.android.synthetic.main.item_new_restaurant.view.*

class NewRestaurantViewHolder(itemView: View, private val delegate: RestaurantActionDelegate) : BaseViewHolder<RestaurantVO>(itemView) {

    init {
        itemView.tvLocation.visibility = View.GONE
    }

    override fun bindData(data: RestaurantVO) {
        itemView.tvRestaurantName.text = data.name
        itemView.tvRestaurantType.text = data.type
        itemView.tvRating.text = data.rating.toString()

        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.ivRestaurantImg)

        itemView.setOnClickListener {
            delegate.onTapRestaurant(data)
        }
    }
}