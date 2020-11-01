package com.padcx.happy_food_delivery.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.happy_food_delivery.R
import com.padcx.happy_food_delivery.adapters.MyOrderRecyclerAdapter
import com.padcx.happy_food_delivery.data.vos.MyOrderVO
import com.padcx.happy_food_delivery.fragments.CheckOutBottomSheetDialogFragment
import com.padcx.happy_food_delivery.mvp.presenters.MyOrderPresenter
import com.padcx.happy_food_delivery.mvp.presenters.impls.MyOrderPresenterImpl
import com.padcx.happy_food_delivery.mvp.views.MyOrderView
import kotlinx.android.synthetic.main.activity_my_orders.*

class MyOrdersActivity : BaseActivity(), MyOrderView {

    private lateinit var mPresenter: MyOrderPresenter

    private lateinit var mMyOrderAdapter: MyOrderRecyclerAdapter

    private var name = ""
    private var count = 0
    private var price = 0

    private var orderList: List<MyOrderVO> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_orders)

        ivLeftArrow.setOnClickListener { onBackPressed() }

        name = intent.getStringExtra(EXTRA_FO0D_NAME) as String
        count = intent.getIntExtra(EXTRA_COUNT, 0)
        price = intent.getIntExtra(EXTRA_PRICE, 0)

        setUpPresenter()
        mPresenter.onUIReady(this, name, count, price)
        setUpRecycler()

        setUpActionListener()
    }

    private fun setUpActionListener() {
        btnCheckOut.setOnClickListener {
            mPresenter.onTapCheckOut(orderList)
        }
    }

    private fun setUpRecycler() {
        mMyOrderAdapter = MyOrderRecyclerAdapter(mPresenter)

        val layoutManager = LinearLayoutManager(this)
        rvOrders.layoutManager = layoutManager
        rvOrders.addItemDecoration(DividerItemDecoration(rvOrders.context, layoutManager.orientation))
        rvOrders.adapter = mMyOrderAdapter

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MyOrderPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    companion object{

        const val EXTRA_FO0D_NAME = "EXTRA_FO0D_NAME"
        const val EXTRA_COUNT = "EXTRA_COUNT"
        const val EXTRA_PRICE = "EXTRA_PRICE"
        const val EXTRA_RESTAURANT = "EXTRA_RESTAURANT"

        fun newIntent(context: Context, name: String, count: Int, price: Int): Intent{
            val intent = Intent(context, MyOrdersActivity::class.java)
            intent.putExtra(EXTRA_FO0D_NAME, name)
            intent.putExtra(EXTRA_COUNT, count)
            intent.putExtra(EXTRA_PRICE, price)
            return intent
        }
    }

    override fun showOrders(order: List<MyOrderVO>) {
        orderList = order
        mMyOrderAdapter.setNewData(order)

        var subTotal = 0
        for (myOrder in order){
            subTotal += myOrder.price
        }
        tvTotalPrice.text = "$$subTotal"
    }

    override fun showCheckOutBottomSheet() {
        CheckOutBottomSheetDialogFragment().apply {
            show(supportFragmentManager, tag)
        }
    }

}