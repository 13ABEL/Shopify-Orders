package com.shopifyorders.presentation.orderyear

import com.shopifyorders.data.OrderRepository
import com.shopifyorders.domain.Order

class OrderYearPresenter (val view :Contract.View) : Contract.Presenter {

    override fun retrieveOrders(orderRepo: OrderRepository) {
         orderRepo.retreiveOrderYear(this)
     }


    override fun receiveOrders(orders: List<Order>) {

    }
    
}