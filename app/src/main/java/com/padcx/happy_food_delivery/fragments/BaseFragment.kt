package com.padcx.happy_food_delivery.fragments

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.padcx.happy_food_delivery.mvp.views.BaseView

abstract class BaseFragment: Fragment(),BaseView {

    override fun showError(error: String) {
        Snackbar.make(activity?.window!!.decorView, error, Snackbar.LENGTH_LONG).show()
    }
}