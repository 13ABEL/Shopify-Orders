package com.shopifyorders.data.datamodel

import java.util.*

class OrderImpl(
        val orderID: String,
        val province: String,
        val orderDate:Date
    ) : Order {

    override fun getDate(): Date {
        return this.orderDate
    }

    override fun getProvinceCode(): String {
        return this.province
    }


}