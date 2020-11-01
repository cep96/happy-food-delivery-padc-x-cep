package com.padcx.happy_food_delivery.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.happy_food_delivery.data.vos.FoodVO
import kotlinx.android.synthetic.main.item_category.view.*

class FoodCategoryViewHolder(itemView: View) : BaseViewHolder<FoodVO>(itemView) {

    override fun bindData(data: FoodVO) {
        itemView.tvCategory.text = data.type

        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.ivCategory)
    }
}