package com.padcx.happy_food_delivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happy_food_delivery.mvp.views.LoginView

interface LoginPresenter: BasePresenter<LoginView> {

    fun onUIReady(owner: LifecycleOwner)
    fun onTapBtnLogin()
    fun onTapBtnSignUp()

}