package com.padcx.happy_food_delivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happy_food_delivery.mvp.views.AccountView

interface AccountPresenter: BasePresenter<AccountView> {

    fun onUIReady(owner: LifecycleOwner)
    fun onTapProfile()
    fun onTapSave(userName: String, profile: String)
}