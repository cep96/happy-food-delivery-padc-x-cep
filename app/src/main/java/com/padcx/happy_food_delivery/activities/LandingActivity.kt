package com.padcx.happy_food_delivery.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.adapters.ImageSliderAdapter
import com.padcx.happy_food_delivery.mvp.presenters.LandingPresenter
import com.padcx.happy_food_delivery.mvp.presenters.impls.LandingPresenterImpl
import com.padcx.happy_food_delivery.mvp.views.LandingView
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.activity_landing.*

class LandingActivity : BaseActivity(), LandingView {

    private lateinit var mPresenter: LandingPresenter

    private lateinit var mSliderAdapter: ImageSliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        setUpPresenter()
        setUpSliderAdapter()

        setUpActionListener()
    }

    private fun setUpActionListener() {
        btnCreateAccount.setOnClickListener {
            mPresenter.onTapCreateAccount()
        }

        tvLogin.setOnClickListener {
            mPresenter.onTapLogin()
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(LandingPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpSliderAdapter() {
        mSliderAdapter = ImageSliderAdapter()

        imageSlider.setSliderAdapter(mSliderAdapter)

        imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        imageSlider.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH;
        imageSlider.indicatorSelectedColor = Color.WHITE;
        imageSlider.indicatorUnselectedColor = Color.GRAY;
        imageSlider.scrollTimeInSec = 4; //set scroll delay in seconds :
        imageSlider.startAutoCycle();
    }

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context, LandingActivity::class.java)
        }
    }

    override fun navigateToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
        finish()
    }

    override fun navigateToCreateAccountScreen() {
        startActivity(SignUpActivity.newIntent(this))
    }
}