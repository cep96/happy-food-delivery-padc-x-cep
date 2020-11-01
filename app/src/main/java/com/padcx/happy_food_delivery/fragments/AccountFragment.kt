package com.padcx.happy_food_delivery.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.mvp.presenters.AccountPresenter
import com.padcx.happy_food_delivery.mvp.presenters.impls.AccountPresenterImpl
import com.padcx.happy_food_delivery.mvp.views.AccountView
import kotlinx.android.synthetic.main.fragment_account.*
import java.io.IOException

class AccountFragment : BaseFragment(), AccountView {

    private lateinit var mPresenter: AccountPresenter
    private var filePath: String ?= ""

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
        ivCamera.setOnClickListener {
            mPresenter.onTapProfile()
        }

        tvSave.setOnClickListener {
            if (filePath == ""){
                //
            }else{
                mPresenter.onTapSave(etUserName.text.toString(), filePath!!)
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

        Glide.with(this.requireActivity())
            .load(userProfile)
            .into(ivProfile)
    }

    override fun openGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            if (data == null || data.data == null) {
                return
            }

            filePath = data.data!!.path

            Glide.with(this.requireContext())
                .load(filePath)
                .into(ivProfile)


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