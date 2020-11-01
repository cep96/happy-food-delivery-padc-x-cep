package com.padcx.happy_food_delivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.happy_food_delivery.data.models.AuthenticationModelImpl
import com.padcx.happy_food_delivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happy_food_delivery.mvp.presenters.AccountPresenter
import com.padcx.happy_food_delivery.mvp.views.AccountView

class AccountPresenterImpl: AccountPresenter, AbstractBasePresenter<AccountView>() {

    private val mAuthenticationModel = AuthenticationModelImpl

    override fun onUIReady(owner: LifecycleOwner) {
        mView.showUserInfo(
            mAuthenticationModel.getUserName(), mAuthenticationModel.getUserEmail(),
            mAuthenticationModel.getUserPhone(), "")
    }

    override fun onTapProfile() {
        mView.openGallery()
    }

    override fun onTapSave(name: String, photoUrl: String) {
        mAuthenticationModel.updateProfile(name, photoUrl)
        mView.showError("Image Uploaded")
    }

}