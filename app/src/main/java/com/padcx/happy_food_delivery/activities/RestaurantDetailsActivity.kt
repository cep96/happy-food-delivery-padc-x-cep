package com.padcx.happy_food_delivery.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.adapters.FoodItemPopularChoiceRecyclerAdapter
import com.padcx.happy_food_delivery.adapters.FoodItemRecyclerAdapter
import com.padcx.happy_food_delivery.data.vos.FoodItemVO
import com.padcx.happy_food_delivery.data.vos.PopularChoiceVO
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import com.padcx.happy_food_delivery.mvp.presenters.RestaurantDetailsPresenter
import com.padcx.happy_food_delivery.mvp.presenters.impls.RestaurantDetailsPresenterImpl
import com.padcx.happy_food_delivery.mvp.views.RestaurantDetailsView
import kotlinx.android.synthetic.main.activity_restaurant_details.*

class RestaurantDetailsActivity : BaseActivity(), RestaurantDetailsView {

    private lateinit var mPresenter: RestaurantDetailsPresenter

    private lateinit var mFoodItemAdapter: FoodItemRecyclerAdapter
    private lateinit var mFoodItemPopularChoicesAdapter: FoodItemPopularChoiceRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_details)

        val restaurant = intent.getSerializableExtra(EXTRA_RESTAURANT) as RestaurantVO

        setUpPresenter()
        ivLeftArrow.setOnClickListener { onBackPressed() }

        setUpRecycler()

        mPresenter.onUIReady(this, restaurant)
        restaurant.id?.let {
            mPresenter.getFoodItems( it ,restaurant.menu)
            mPresenter.getPopularChoices(it, restaurant.popular_choices)
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(RestaurantDetailsPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecycler() {

        mFoodItemAdapter = FoodItemRecyclerAdapter(mPresenter)
        rvFoodItem.layoutManager = LinearLayoutManager(this)
        rvFoodItem.adapter = mFoodItemAdapter

        mFoodItemPopularChoicesAdapter = FoodItemPopularChoiceRecyclerAdapter(mPresenter)
        rvPopularChoices.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvPopularChoices.adapter = mFoodItemPopularChoicesAdapter

    }

    companion object{

        const val EXTRA_RESTAURANT = "EXTRA_RESTAURANT"

        fun newIntent(context: Context, restaurant: RestaurantVO): Intent {
            val intent = Intent(context, RestaurantDetailsActivity::class.java)
            intent.putExtra(EXTRA_RESTAURANT, restaurant)
            return intent
        }
    }

    override fun showDetails(restaurant: RestaurantVO) {
        Glide.with(this)
            .load(restaurant.image)
            .into(ivRestaurantImg)

        tvEstimateTime.text = restaurant.estimate_time
        tvRestaurantName.text = restaurant.name
        tvRating.text = restaurant.rating.toString()
        tvType.text = restaurant.type
        tvLocation.text = restaurant.location
    }

    override fun showPopularChoicesItem(itemFood: List<PopularChoiceVO>) {
        mFoodItemPopularChoicesAdapter.setNewData(itemFood)
    }

    override fun showFoodItems(itemFood: List<FoodItemVO>) {
        mFoodItemAdapter.setNewData(itemFood)
    }

    override fun navigateToOrderScreen(name: String, count: Int, price: Int) {
        startActivity(MyOrdersActivity.newIntent(this, name, count, price))
    }
}