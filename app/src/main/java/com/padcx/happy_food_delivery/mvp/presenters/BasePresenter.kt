package com.padcx.happy_food_delivery.mvp.presenters

import com.padcx.happy_food_delivery.mvp.views.BaseView

interface BasePresenter<V: BaseView> {

    fun initPresenter(view: V)
}