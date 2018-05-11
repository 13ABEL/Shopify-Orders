package com.shopifyorders.domain

interface Item {
    fun getName() : String
    fun getQuantity() : Int
}