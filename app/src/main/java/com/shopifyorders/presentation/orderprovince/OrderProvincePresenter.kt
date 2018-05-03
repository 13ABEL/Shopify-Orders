package com.shopifyorders.presentation.orderprovince

import com.shopifyorders.data.OrderRepository

class OrderProvincePresenter : Contract.Presenter{

    constructor(view: Contract.View) {
        val view = view
    }

    override fun retrieveOrders(orderRepo: OrderRepository) {
        orderRepo.retreiveOrderProvince()
    }

}