package com.padcx.happy_food_delivery.activities

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.padcx.happy_food_delivery.mvp.views.BaseView

abstract class BaseActivity: AppCompatActivity(), BaseView {
    override fun showError(error: String) {
        Snackbar.make(window.decorView, error, Snackbar.LENGTH_LONG).show()
    }

}