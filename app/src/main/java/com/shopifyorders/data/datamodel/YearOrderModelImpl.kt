package com.shopifyorders.data.datamodel

import com.shopifyorders.domain.Order

class YearOrderModelImpl (
        var year: Int
    ): YearOrderModel {

    override fun getOrderYear(): Int {
        return year
    }

    val yearOrders : MutableList<Order> = ArrayList()

    override fun getOrders(): List<Order> {
        return yearOrders
    }

    override fun addOrder(newOrder: Order) {
        yearOrders.add(newOrder)
    }

}