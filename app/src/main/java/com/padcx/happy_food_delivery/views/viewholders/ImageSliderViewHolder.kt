package com.padcx.happy_food_delivery.views.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.padcx.happy_food_delivery.R
import com.smarteist.autoimageslider.SliderViewAdapter

class ImageSliderViewHolder(itemView: View?) : SliderViewAdapter.ViewHolder(itemView) {

    var imageView = itemView?.findViewById<ImageView>(R.id.ivSliderImg)
    var title = itemView?.findViewById<TextView>(R.id.tvTitle)
    var desc = itemView?.findViewById<TextView>(R.id.tvDescription)
}