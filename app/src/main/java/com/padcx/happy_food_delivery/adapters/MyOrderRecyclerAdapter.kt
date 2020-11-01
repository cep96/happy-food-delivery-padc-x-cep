package com.padcx.happy_food_delivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.data.vos.MyOrderVO
import com.padcx.happy_food_delivery.delegates.OrderItemActionDelegate
import com.padcx.happy_food_delivery.views.viewholders.MyOrderViewHolder

class MyOrderRecyclerAdapter(private val delegate: OrderItemActionDelegate): BaseAdapter<MyOrderViewHolder, MyOrderVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyOrderViewHolder {
        return MyOrderViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_order, parent, false),
            delegate
        )
    }
}