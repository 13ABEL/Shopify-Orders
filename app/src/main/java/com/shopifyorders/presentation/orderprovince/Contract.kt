package com.shopifyorders.presentation.orderprovince

import com.shopifyorders.data.OrderRepository
import com.shopifyorders.data.datamodel.Order
import com.shopifyorders.data.datamodel.ProvinceOrderModel

interface Contract {
    interface View {
        fun displayOrders(provinceOrders: List<ProvinceOrderModel>)
    }

    interface Presenter {
        fun retrieveOrders(orderRepo: OrderRepository)
        fun receiveOrders(orders: List<Order>)
    }
}