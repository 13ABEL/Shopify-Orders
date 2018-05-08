package com.shopifyorders.domain

import java.util.*

interface Order {
    fun getDate() : Date
    fun getProvinceCode() : String
}