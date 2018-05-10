package com.shopifyorders.presentation.orderyear

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import com.shopifyorders.R
import com.shopifyorders.data.OrderRespositoryImpl
import com.shopifyorders.data.datamodel.YearOrderModel
import com.shopifyorders.domain.Order
import com.shopifyorders.presentation.adapters.OrderAdapter
import com.shopifyorders.presentation.adapters.YearOrderAdapter
import kotlinx.android.synthetic.main.year_orders.view.*

class OrderYearView : Contract.View, Fragment() {
    val presenter : Contract.Presenter = OrderYearPresenter(this)
    var yearOrderAdapter : YearOrderAdapter = YearOrderAdapter(context)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val rootview = inflater.inflate(R.layout.year_orders, container, false)

        // inflates the recyclerview and attach the tab adapter to it
        val recyclerView = rootview.year_orders_recyclerview
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = yearOrderAdapter

        // retrieves orders
        presenter.retrieveOrders(OrderRespositoryImpl(this.context!!))

        return rootview
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            activity!!.title = "Orders By Year"
        }
    }

    override fun displayOrders(orders: List<YearOrderModel>) {
        yearOrderAdapter.setList(orders)
        yearOrderAdapter.notifyDataSetChanged()

        // hides the progress bar and reveals the recvclerview once the data is loaded
        view!!.findViewById<ProgressBar>(R.id.year_orders_progressbar)
                .visibility = ProgressBar.GONE

        view!!.findViewById<RecyclerView>(R.id.year_orders_recyclerview)
                .visibility = RecyclerView.VISIBLE
    }


}