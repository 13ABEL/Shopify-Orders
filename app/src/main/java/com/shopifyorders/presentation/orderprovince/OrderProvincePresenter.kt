package com.shopifyorders.presentation.orderprovince

import android.util.Log
import com.shopifyorders.data.OrderRepository
import com.shopifyorders.data.datamodel.Order
import com.shopifyorders.data.datamodel.ProvinceOrderModel

class OrderProvincePresenter(val view: Contract.View) : Contract.Presenter{
    val cTAG = "OrderProvince_Presenter"

    override fun retrieveOrders(orderRepo: OrderRepository) {
        orderRepo.retreiveOrderProvince(this)
    }

    override fun receiveOrders(orders: List<Order>) {
        Log.d(cTAG, orders.toString())
    }

}