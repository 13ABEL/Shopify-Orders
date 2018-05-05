package com.shopifyorders.data.datamodel

import java.util.*

class OrderImpl(
        val orderID:String,
        val orderDate:Date
    ) : Order {


    override fun getTime(): Date {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}