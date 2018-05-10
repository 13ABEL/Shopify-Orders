package com.shopifyorders.data.datamodel

import com.shopifyorders.domain.Order

class YearOrderModelImpl (val year: Int): YearOrderModel{

    val yearOrders : MutableList<Order> = ArrayList()


    override fun getOrderYear(): Int {
        return year
    }

    override fun getOrders(): List<Order> {
        return yearOrders
    }

    override fun addOrder(newOrder: Order) {
        yearOrders.add(newOrder)
    }

    override fun getTopOrders(numTop: Int): List<Order> {
        // returns top x number of orders
        return yearOrders.subList(0, numTop)
    }
}