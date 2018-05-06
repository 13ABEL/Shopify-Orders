package com.shopifyorders.data.datamodel

import java.util.*

interface Order {
    fun getTime() : Date
    fun getProvinceCode() : String
}