package com.padcx.happy_food_delivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import com.padcx.happy_food_delivery.delegates.RestaurantActionDelegate
import com.padcx.happy_food_delivery.views.viewholders.RestaurantViewHolder

class RestaurantRecyclerAdapter(
    private val view: Int,
    private val delegate: RestaurantActionDelegate
)
    : BaseAdapter<RestaurantViewHolder, RestaurantVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {

        when(view){
            0 -> {
                return RestaurantViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_restaurant, parent, false),
                    view, delegate
                )
            }
            1 -> {
                return RestaurantViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_new_restaurant, parent, false),
                    view, delegate
                )
            }
            2 -> {
                return RestaurantViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_popular_choices, parent, false),
                    view, delegate
                )
            }
            else -> {
                return RestaurantViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_restaurant, parent, false),
                    view, delegate
                )
            }
        }


    }
}