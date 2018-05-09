package com.shopifyorders.data.datamodel

import com.shopifyorders.domain.Order

interface YearOrderModel {
    fun getOrderYear() : Int
    fun addOrder(newOrder: Order)
    fun getOrders() : List <Order>
}