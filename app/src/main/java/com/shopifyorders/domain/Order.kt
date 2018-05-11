package com.shopifyorders.domain

import java.util.*

interface Order {
    fun getDate() : Date
    fun getProvinceCode() : String

    fun getTotal() : Double
    fun getOrderCurrency() : String

    fun getLastModified() : String
    fun getAuthorEmail() : String

    fun getOrderItems() : List<Item>
}