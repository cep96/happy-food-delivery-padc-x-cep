package com.padcx.happy_food_delivery.views.viewholders

import android.view.View
import com.padcx.happy_food_delivery.data.vos.FoodItemVO
import com.padcx.happy_food_delivery.delegates.FoodItemActionDelegate
import kotlinx.android.synthetic.main.item_food.view.*

class FoodItemViewHolder(
    itemView: View, private val delegate: FoodItemActionDelegate)
    : BaseViewHolder<FoodItemVO>(itemView) {

    override fun bindData(data: FoodItemVO) {

        var ingredients = ""

        itemView.tvFoodName.text = data.name
        itemView.tvPrice.text = "$${data.price}"

        if (data.isPopular){
            itemView.tvIsPopular.visibility = View.VISIBLE
        }else{
            itemView.tvIsPopular.visibility = View.INVISIBLE
        }

        for (item in data.ingredients){
            ingredients = if (ingredients.isNullOrEmpty()){
                "$item"
            }else{
                "$ingredients, $item"
            }
        }

        itemView.setOnClickListener {
            delegate.onTapFoodItem(data.name!!, 1, data.price )
        }
    }
}