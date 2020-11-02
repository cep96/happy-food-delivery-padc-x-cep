package com.padcx.happy_food_delivery.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.mvp.presenters.AccountPresenter
import com.padcx.happy_food_delivery.mvp.presenters.impls.AccountPresenterImpl
import com.padcx.happy_food_delivery.mvp.views.AccountView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_account.*
import java.io.IOException

class AccountFragment : BaseFragment(), AccountView {

    private lateinit var mPresenter: AccountPresenter
    private var tempBitmap: Bitmap?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        mPresenter.onUIReady(this)

        setUpActionListener()
    }

    private fun setUpActionListener() {
        flProfile.setOnClickListener {
//            mPresenter.onTapProfile()
            openGallery()
        }

        tvSave.setOnClickListener {
            tempBitmap?.let {
                mPresenter.onTapSave(etEmail.text.toString(), it)
            }
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this.requireActivity()).get(AccountPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun showUserInfo(
        userName: String,
        userEmail: String,
        userPhone: String,
        userProfile: String
    ) {
        etUserName.setText(userName)
        etUserEmail.setText(userEmail)
        etUserPhone.setText(userPhone)

        userProfile.let {
            Glide.with(this.requireActivity())
                .load(it)
                .into(ivProfile)
        }
    }

    override fun openGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            if (data == null || data.data == null) {
                return
            }

            val filePath = data.data
            Log.d("filePath", "==> $filePath")
            try {

                filePath?.let {
                    if (Build.VERSION.SDK_INT >= 29) {
                        val source: ImageDecoder.Source =
                            ImageDecoder.createSource(this.requireContext().contentResolver, filePath)

                        val bitmap = ImageDecoder.decodeBitmap(source)
                        tempBitmap = bitmap
                    } else {
                        val bitmap = MediaStore.Images.Media.getBitmap(
                            this.requireContext().contentResolver, filePath
                        )
                        tempBitmap = bitmap
                    }
                    ivProfile.setImageBitmap(tempBitmap)
                }


            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
    }

    companion object {

        const val PICK_IMAGE_REQUEST = 1111

        @JvmStatic
        fun newInstance() =
            AccountFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}