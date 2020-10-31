package com.padcx.happy_food_delivery.activities

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.mvp.presenters.StartPresenter
import com.padcx.happy_food_delivery.mvp.presenters.impls.StartPresenterImpl
import com.padcx.happy_food_delivery.mvp.views.StartView
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : BaseActivity(), StartView {

    private lateinit var mPresenter: StartPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        setUpPresenter()
        setUpActionListener()

    }

    private fun setUpActionListener() {
        btnGetStarted.setOnClickListener {
            mPresenter.onTapGetStarted()
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(StartPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun navigateToLandingScreen() {
        startActivity(LandingActivity.newIntent(this))
        finish()
    }
}