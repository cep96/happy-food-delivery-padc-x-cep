package com.padcx.happy_food_delivery.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.mvp.presenters.LoginPresenter
import com.padcx.happy_food_delivery.mvp.presenters.impls.LoginPresenterImpl
import com.padcx.happy_food_delivery.mvp.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginView {

    private lateinit var mPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setUpPresenter()
        setUpActionListener()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(LoginPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpActionListener() {
        btnLogin.setOnClickListener {
            // TODO login button action
        }

        tvSignUp.setOnClickListener {
            mPresenter.onTapBtnSignUp()
        }
    }

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    override fun navigateToHomeScreen() {
        TODO("Not yet implemented")
    }

    override fun navigateSignUpScreen() {
        startActivity(SignUpActivity.newIntent(this))
        finish()
    }
}