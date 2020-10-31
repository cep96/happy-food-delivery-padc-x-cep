package com.padcx.happy_food_delivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.adapters.FoodCategoryRecyclerAdapter
import com.padcx.happy_food_delivery.adapters.RestaurantRecyclerAdapter
import com.padcx.happy_food_delivery.data.vos.FoodVO
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import com.padcx.happy_food_delivery.mvp.presenters.RestaurantsPresenter
import com.padcx.happy_food_delivery.mvp.presenters.impls.RestaurantsPresenterImpl
import com.padcx.happy_food_delivery.mvp.views.RestaurantsView
import kotlinx.android.synthetic.main.fragment_restaurants.*

class RestaurantsFragment : Fragment(), RestaurantsView {

    private lateinit var mPresenter: RestaurantsPresenter

    private lateinit var mRestaurantAdapter: RestaurantRecyclerAdapter
    private lateinit var mFoodCategoryAdapter: FoodCategoryRecyclerAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurants, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()

        mPresenter.onUIReady(this)
        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        mRestaurantAdapter = RestaurantRecyclerAdapter()
        rvRestaurant.layoutManager = LinearLayoutManager(this.requireContext())
        rvRestaurant.adapter = mRestaurantAdapter

        // set recycler for food category
        mFoodCategoryAdapter = FoodCategoryRecyclerAdapter()
        rvCategory.layoutManager = LinearLayoutManager(this.requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvCategory.adapter = mFoodCategoryAdapter
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this.requireActivity()).get(RestaurantsPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    companion object{
        fun newInstance(): Fragment{
            return RestaurantsFragment()
        }
    }

    override fun showCategories(categories: List<FoodVO>) {
        mFoodCategoryAdapter.setNewData(categories)
    }

    override fun showRestaurants(restaurants: List<RestaurantVO>) {
        mRestaurantAdapter.setNewData(restaurants)
    }

    override fun showError(error: String) {
        TODO("Not yet implemented")
    }
}