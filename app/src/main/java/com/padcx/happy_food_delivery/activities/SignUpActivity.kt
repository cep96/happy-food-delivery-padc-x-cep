package com.padcx.happy_food_delivery.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.mvp.presenters.SignUpPresenter
import com.padcx.happy_food_delivery.mvp.presenters.impls.SignUpPresenterImpl
import com.padcx.happy_food_delivery.mvp.views.SignUpView
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : BaseActivity(), SignUpView {

    lateinit var mPresenter: SignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setUpPresenter()
        setUpActionListener()
    }

    private fun setUpActionListener() {
        tvLogin.setOnClickListener {
            mPresenter.onTapBtnLogin()
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(SignUpPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context, SignUpActivity::class.java)
        }
    }

    override fun navigateToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
        finish()
    }
}