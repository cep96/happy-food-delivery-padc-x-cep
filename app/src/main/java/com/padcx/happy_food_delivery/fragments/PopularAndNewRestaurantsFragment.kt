package com.padcx.happy_food_delivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.adapters.NewRestaurantRecyclerAdapter
import com.padcx.happy_food_delivery.adapters.PopularChoiceRecyclerAdapter
import com.padcx.happy_food_delivery.data.vos.RestaurantVO
import com.padcx.happy_food_delivery.mvp.presenters.PopularAndNewRestaurantsPresenter
import com.padcx.happy_food_delivery.mvp.presenters.impls.PopularAndNewRestaurantsPresenterImpl
import com.padcx.happy_food_delivery.mvp.views.BaseView
import com.padcx.happy_food_delivery.mvp.views.PopularAndNewRestaurantsView
import kotlinx.android.synthetic.main.fragment_popular_and_new_restaurants.*

private const val ARG_PARAM1 = "param1"

class PopularAndNewRestaurantsFragment : BaseFragment(), PopularAndNewRestaurantsView {
    private var param1: String? = null

    private lateinit var mPresenter: PopularAndNewRestaurantsPresenter

    private lateinit var mPopularChoicesAdapter: PopularChoiceRecyclerAdapter
    private lateinit var mNewRestaurantsAdapter: NewRestaurantRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular_and_new_restaurants, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpRecyclerView()

        mPresenter.onUIReady(this)

    }

    private fun setUpRecyclerView() {

        mPopularChoicesAdapter = PopularChoiceRecyclerAdapter()
        rvPopularChoices.layoutManager = LinearLayoutManager(this.requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvPopularChoices.adapter = mPopularChoicesAdapter

        mNewRestaurantsAdapter = NewRestaurantRecyclerAdapter()
        val layoutManager = LinearLayoutManager(this.requireContext(), LinearLayoutManager.VERTICAL, false)
        rvNewRestaurants.layoutManager = layoutManager
        rvNewRestaurants.addItemDecoration(DividerItemDecoration(rvNewRestaurants.context, layoutManager.orientation))
        rvNewRestaurants.adapter = mNewRestaurantsAdapter
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this.requireActivity()).get(PopularAndNewRestaurantsPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            PopularAndNewRestaurantsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }

    override fun showNewRestaurants(newRestaurants: List<RestaurantVO>) {
        mNewRestaurantsAdapter.setNewData(newRestaurants)
    }

    override fun showPopularChoices(popularChoices: List<RestaurantVO>) {
        mPopularChoicesAdapter.setNewData(popularChoices)
    }
}