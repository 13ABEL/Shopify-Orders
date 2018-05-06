package com.shopifyorders.presentation.orderprovince

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shopifyorders.R
import com.shopifyorders.data.OrderRepository
import com.shopifyorders.data.OrderRespositoryImpl
import com.shopifyorders.data.datamodel.Order
import com.shopifyorders.data.datamodel.ProvinceOrderModel
import com.shopifyorders.data.datamodel.ProvinceOrderModelImpl
import com.shopifyorders.presentation.adapters.ProvinceOrderAdapter
import java.util.*
import kotlin.collections.ArrayList

class OrderProvinceView() : Contract.View, Fragment() {
    val presenter : Contract.Presenter = OrderProvincePresenter(this)
    var provinceOrderAdapter = ProvinceOrderAdapter(context)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        var rootview = inflater.inflate(R.layout.province_orders, container, false)

        // initialize the repository and inject it into the presenter
        val orderRepo : OrderRepository = OrderRespositoryImpl(rootview.context)
        presenter.retrieveOrders(orderRepo)

        // initialize the recycler view reference and layout manager
        val recyclerView = rootview.findViewById<RecyclerView>(R.id.province_orders_recyclerview)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.setHasFixedSize(true)

        // tells presenter to fetch the orders
        presenter.retrieveOrders(orderRepo)

        // attach the adapter to the list
        recyclerView.adapter = provinceOrderAdapter

        return rootview
    }

    override fun displayProvinceOrders(provinceOrders: List<ProvinceOrderModel>) {
        // sends the items to the adapter to be displayed
        provinceOrderAdapter.setList(provinceOrders)
        provinceOrderAdapter.notifyDataSetChanged()
    }

}