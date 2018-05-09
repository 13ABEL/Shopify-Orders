package com.shopifyorders.presentation.orderyear

import com.shopifyorders.data.OrderRepository
import com.shopifyorders.data.datamodel.YearOrderModel
import com.shopifyorders.domain.Order

interface Contract {

    interface View {
        fun displayOrders(orders: List<YearOrderModel>)
    }

    interface Presenter{
        fun retrieveOrders(orderRepo: OrderRepository)
        fun receiveOrders(orders: List<Order>)
        fun getYears() : List<Int>
        fun getYearOrder(year: Int) : YearOrderModel
    }
}