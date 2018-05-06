package com.shopifyorders.data.datamodel

interface ProvinceOrderModel {
    fun getName() : String
    fun addOrder(newOrder: Order)
    fun getTotal() : Int
    fun getLatestOrder() : Order
}