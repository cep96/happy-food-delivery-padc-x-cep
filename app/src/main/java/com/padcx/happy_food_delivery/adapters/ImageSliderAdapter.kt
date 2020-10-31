package com.padcx.happy_food_delivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.data.vos.SliderImageVO
import com.padcx.happy_food_delivery.views.viewholders.ImageSliderViewHolder
import com.smarteist.autoimageslider.SliderViewAdapter

class ImageSliderAdapter: SliderViewAdapter<ImageSliderViewHolder>() {

    private val sliderList = arrayListOf(
        SliderImageVO(R.drawable.foods, R.string.slider_lbl_foods, R.string.slider_lbl_foods_desc),
        SliderImageVO(R.drawable.fast_delivery, R.string.slider_lbl_fast_delivery, R.string.slider_lbl_fast_delivery_desc),
        SliderImageVO(R.drawable.tracking, R.string.slider_lbl_live_tracking, R.string.slider_lbl_live_tracking_desc)
    )

    override fun onCreateViewHolder(parent: ViewGroup?): ImageSliderViewHolder {
        return ImageSliderViewHolder(
            LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_image_slider, parent, false)
        )
    }

    override fun getCount(): Int {
        return sliderList.count()
    }

    override fun onBindViewHolder(viewHolder: ImageSliderViewHolder?, position: Int) {

        viewHolder?.imageView?.setImageResource(sliderList[position].image)
        viewHolder?.title?.setText(sliderList[position].title)
        viewHolder?.desc?.setText(sliderList[position].description)
    }
}