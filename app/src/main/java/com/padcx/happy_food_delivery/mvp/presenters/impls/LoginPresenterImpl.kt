package com.padcx.happy_food_delivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.happy_food_delivery.data.models.AuthenticationModel
import com.padcx.happy_food_delivery.data.models.AuthenticationModelImpl
import com.padcx.happy_food_delivery.data.models.FoodDeliveryModelImpl
import com.padcx.happy_food_delivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happy_food_delivery.mvp.presenters.LoginPresenter
import com.padcx.happy_food_delivery.mvp.views.LoginView

class LoginPresenterImpl: LoginPresenter, AbstractBasePresenter<LoginView>() {

    private val mAuthenticationModelImpl: AuthenticationModel = AuthenticationModelImpl
    private val mFoodDeliveryModel = FoodDeliveryModelImpl

    override fun onUIReady(owner: LifecycleOwner) {
        mFoodDeliveryModel.setUpRemoteConfigWithDefaultValues()
        mFoodDeliveryModel.fetchRemoteConfig()
    }

    override fun onTapBtnLogin(email: String, password: String) {
        mAuthenticationModelImpl.login(email, password, onSuccess = {
            mView.navigateToHomeScreen()
        }, onFailure = {
           mView.showError(it)
        })
    }

    override fun onTapBtnSignUp() {
        mView.navigateSignUpScreen()
    }
}