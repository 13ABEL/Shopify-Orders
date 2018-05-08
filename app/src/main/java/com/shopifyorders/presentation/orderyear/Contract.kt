package com.shopifyorders.presentation.orderyear

import com.shopifyorders.data.OrderRepository
import com.shopifyorders.domain.Order

interface Contract {

    interface View {

    }

    interface Presenter{
        fun retrieveOrders(orderRepo: OrderRepository)
        fun receiveOrders(orders: List<Order>)
    }
}