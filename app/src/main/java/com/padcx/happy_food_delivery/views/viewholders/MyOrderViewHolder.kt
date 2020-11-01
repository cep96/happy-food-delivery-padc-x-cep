package com.padcx.happy_food_delivery.views.viewholders

import android.view.View
import com.padcx.happy_food_delivery.data.vos.MyOrderVO
import com.padcx.happy_food_delivery.delegates.OrderItemActionDelegate
import kotlinx.android.synthetic.main.item_order.view.*

class MyOrderViewHolder(
    itemView: View, private val delegate: OrderItemActionDelegate)
    : BaseViewHolder<MyOrderVO>(itemView) {

    override fun bindData(data: MyOrderVO) {

        var count = data.count

        itemView.tvOrderName.text = data.name
        itemView.tvCost.text = "$${data.price}"

        itemView.tvCount.text = "$count"

        itemView.btnAdd.setOnClickListener {
            itemView.tvCount.text = "${count++}"
            delegate.onTapBtnAdd(data.name!!, count, data.price*count, data.origin_price )
        }

        itemView.btnRemove.setOnClickListener {
            itemView.tvCount.text = "${count--}"
            delegate.onTapBtnRemove(data.name!!, count, data.price - data.origin_price, data.origin_price)
        }
    }
}