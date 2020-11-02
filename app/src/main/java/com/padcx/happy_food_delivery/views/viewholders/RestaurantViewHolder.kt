package com.padcx.happy_food_delivery.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import com.padcx.happy_food_delivery.delegates.RestaurantActionDelegate
import kotlinx.android.synthetic.main.item_new_restaurant.view.*
import kotlinx.android.synthetic.main.item_restaurant.view.*
import kotlinx.android.synthetic.main.item_restaurant.view.ivRestaurantImg
import kotlinx.android.synthetic.main.item_restaurant.view.tvRating
import kotlinx.android.synthetic.main.item_restaurant.view.tvRestaurantName
import kotlinx.android.synthetic.main.item_restaurant.view.tvRestaurantType

class RestaurantViewHolder(
    itemView: View, private val viewType: Int,
    private val delegate: RestaurantActionDelegate
) : BaseViewHolder<RestaurantVO>(itemView) {

    override fun bindData(data: RestaurantVO) {

        if (viewType == 1){
            itemView.tvLocation.visibility = View.INVISIBLE
        }

        itemView.tvRestaurantName.text = data.name
        itemView.tvRating.text = data.rating.toString()
        itemView.tvRestaurantType.text = data.type

        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.ivRestaurantImg)

        itemView.setOnClickListener {
            delegate.onTapRestaurant(data)
        }
    }

}