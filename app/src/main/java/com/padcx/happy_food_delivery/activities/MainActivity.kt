package com.padcx.happy_food_delivery.activities

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.fragments.AccountFragment
import com.padcx.happy_food_delivery.fragments.OffersFragment
import com.padcx.happy_food_delivery.fragments.PopularAndNewRestaurantsFragment
import com.padcx.happy_food_delivery.fragments.RestaurantsFragment
import com.padcx.happy_food_delivery.mvp.presenters.MainPresenter
import com.padcx.happy_food_delivery.mvp.presenters.impls.MainPresenterImpl
import com.padcx.happy_food_delivery.mvp.views.MainView
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : BaseActivity(), MainView {

    private var viewType = 0

    private lateinit var mPresenter: MainPresenter

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()

        mPresenter.onUIReady(this)

        if (viewType == 1){
            loadFragment(PopularAndNewRestaurantsFragment.newInstance(""))
        }else{
            loadFragment(RestaurantsFragment.newInstance())
        }

        setUpActionListener()

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun setUpActionListener() {
        bottomNavView.setOnNavigationItemSelectedListener { item: MenuItem ->  
            when(item.itemId){
                R.id.nav_restaurants ->{
                    if (viewType == 1){
                        loadFragment(PopularAndNewRestaurantsFragment.newInstance(""))
                    }else{
                        loadFragment(RestaurantsFragment.newInstance())
                    }
                    true
                }
                R.id.nav_offers -> {
                    loadFragment(OffersFragment.newInstance())
                    true
                }
                R.id.nav_account -> {
                    loadFragment(AccountFragment.newInstance())
                    true
                }
                else ->{
                    loadFragment(RestaurantsFragment.newInstance())
                }
            }
            false
        }
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun getViewType(type: Int) {
        viewType = type
    }
}