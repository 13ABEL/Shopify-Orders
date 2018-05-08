package com.shopifyorders.data.datamodel

import com.shopifyorders.domain.Order

interface ProvinceOrderModel {
    fun getName() : String
    fun addOrder(newOrder: Order)
    fun getTotal() : Int
    fun getLatestOrderInfo() : String
}