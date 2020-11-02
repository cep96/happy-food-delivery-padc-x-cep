package com.padcx.happy_food_delivery.mvp.presenters.impls

import android.graphics.Bitmap
import android.net.Uri
import androidx.lifecycle.LifecycleOwner
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.storage.FirebaseStorage
import com.padcx.happy_food_delivery.data.models.AuthenticationModelImpl
import com.padcx.happy_food_delivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happy_food_delivery.mvp.presenters.AccountPresenter
import com.padcx.happy_food_delivery.mvp.views.AccountView
import java.io.ByteArrayOutputStream
import java.util.*

class AccountPresenterImpl: AccountPresenter, AbstractBasePresenter<AccountView>() {

    private val mAuthenticationModel = AuthenticationModelImpl

    private val storage = FirebaseStorage.getInstance()
    private val storageReference = storage.reference

    override fun onUIReady(owner: LifecycleOwner) {
        mView.showUserInfo(
            mAuthenticationModel.getUserName(), mAuthenticationModel.getUserEmail(),
            mAuthenticationModel.getUserPhone(), "")
    }

    override fun onTapProfile() {
        mView.openGallery()
    }

    override fun onTapSave(email: String, bitmap: Bitmap) {
//        mAuthenticationModel.updateProfile(name, bitmap)
//        mView.showError("Image Uploaded")
        uploadProfile(email, bitmap)
    }

    private fun uploadProfile(email: String, bitmap: Bitmap) {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        val imageRef = storageReference.child("images/${UUID.randomUUID()}" )
        val uploadTask = imageRef.putBytes(data)

        uploadTask.addOnFailureListener {

        }.addOnSuccessListener {

        }

        uploadTask.continueWithTask {
            return@continueWithTask imageRef.downloadUrl
        }.addOnCompleteListener {task ->
            val imageUrl = task.result?.toString()

            val userProfileChangeRequest = userProfileChangeRequest {
                photoUri = Uri.parse(imageUrl)
            }

            mAuthenticationModel.updateProfile(email, userProfileChangeRequest, onSuccess = {
                mView.showUserInfo(it.displayName!!, it.email!!, it.phoneNumber!!, it.photoUrl.toString())
            }, onFailure = {
                mView.showError(it)
            })
        }

    }
}