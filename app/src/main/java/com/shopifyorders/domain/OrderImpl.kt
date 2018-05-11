package com.shopifyorders.domain

import com.shopifyorders.domain.Order
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

    override fun getLastModified(): String {
        val currentTime : Long = Date().time
        var differenceString = ""

        // converts latest order to days, hours, or minutes
        val difference = (currentTime - this.orderDate.time)/1000
        if (difference < 60) {
            differenceString = (difference/60).toString() + " minutes ago"
        }
        else if (difference < 60*60) {
            differenceString = (difference/60/60).toString() + " hours ago"
        }
        else {
            differenceString = (difference/60/60/24).toString() + " days ago"
        }

        return differenceString
    }

    /**
     *  retreive the list of orders
     */
    override fun getOrderItems() : List<Item> {
        return items
    }


}