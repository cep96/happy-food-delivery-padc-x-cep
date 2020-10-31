package com.padcx.happy_food_delivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.happy_food_delivery.data.models.FoodDeliveryModelImpl
import com.padcx.happy_food_delivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happy_food_delivery.mvp.presenters.MainPresenter
import com.padcx.happy_food_delivery.mvp.views.MainView

class MainPresenterImpl: MainPresenter, AbstractBasePresenter<MainView>() {

    private val mFoodDeliveryModel = FoodDeliveryModelImpl

    override fun onUIReady(owner: LifecycleOwner) {
        mView.getViewType(mFoodDeliveryModel.getRemoteConfigViewType())
    }
}