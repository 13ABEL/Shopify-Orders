package com.shopifyorders.presentation.orderprovince

import com.shopifyorders.data.OrderRepository

interface Contract {
    interface View {


    }

    interface Presenter {
        fun retrieveOrders(orderRepo: OrderRepository)
    }
}