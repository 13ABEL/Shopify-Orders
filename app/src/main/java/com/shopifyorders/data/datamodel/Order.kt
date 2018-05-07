package com.shopifyorders.data.datamodel

import java.util.*

interface Order {
    fun getDate() : Date
    fun getProvinceCode() : String
}