package com.shopifyorders.data.datamodel

import java.util.*

interface ProvinceOrderModel {
    fun getName() : String
    fun addOrder(newOrder: Order)
    fun getTotal() : Int
    fun getLatestOrder() : String
}