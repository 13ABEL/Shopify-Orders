package com.shopifyorders.domain

import com.shopifyorders.domain.Order
import java.text.SimpleDateFormat
import java.util.*

open class OrderImpl (val orderID: String,
                      val province: String,
                      val orderDate: Date,
                      val orderAuthorEmail: String,
                      val orderTotal: Double,
                      val currency: String,
                      val items: List<Item>) : Order {

    override fun getDate(): Date {
        return this.orderDate
    }

    override fun getProvinceCode(): String {
        return this.province
    }

    override fun getTotal(): Double {
        return this.orderTotal
    }

    override fun getAuthorEmail(): String {
        return this.orderAuthorEmail
    }

    override fun getOrderCurrency(): String {
        return this.currency
    }

    override fun getLastModified(): Date {
        return this.orderDate
    }

    /**
     *  retreive the list of orders
     */
    override fun getOrderItems() : List<Item> {
        return items
    }


}