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

        mPresenter.onUIReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(LoginPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpActionListener() {
        btnLogin.setOnClickListener {
           mPresenter.onTapBtnLogin(etEmail.text.toString(), etPassword.text.toString())
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
        startActivity(MainActivity.newIntent(this))
        finish()
    }

    override fun navigateSignUpScreen() {
        startActivity(SignUpActivity.newIntent(this))
    }
}