package com.shopifyorders.presentation.orderprovince

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shopifyorders.R
import com.shopifyorders.data.OrderRepository
import com.shopifyorders.data.OrderRespositoryImpl

class OrderProvinceView() : Contract.View, Fragment() {
    val presenter : Contract.Presenter = OrderProvincePresenter(this)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        var rootview = inflater.inflate(R.layout.province_orders, container, false)

        // initialize the repository and inject it into the presenter
        val orderRepo : OrderRepository = OrderRespositoryImpl(rootview.context)
        presenter.retrieveOrders(orderRepo)

        return rootview
    }

}