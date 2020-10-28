package com.padcx.happy_food_delivery.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padcx.happy_food_delivery.mvp.views.BaseView

abstract class AbstractBasePresenter<T: BaseView>: BasePresenter<T>, ViewModel() {

    protected lateinit var mView: T

    override fun initPresenter(view: T) {
        mView = view
    }

}