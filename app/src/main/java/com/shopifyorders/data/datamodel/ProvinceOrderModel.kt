package com.shopifyorders.data.datamodel

interface ProvinceOrderModel {
    fun addOrder(newOrder: Order)
    fun getLatestOrder() : Order
}