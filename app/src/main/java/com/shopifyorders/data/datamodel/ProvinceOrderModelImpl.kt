package com.shopifyorders.data.datamodel

import java.util.*
import kotlin.collections.ArrayList

class ProvinceOrderModelImpl(
        var provinceName : String
    ) : ProvinceOrderModel {


    override fun addOrder(newOrder: Order) {

    }

    val provinceOrders = ArrayList<Order>()

    override fun getLatestOrder() : Order {
        // initialize the refences to be compares
        var latestOrder: Order = provinceOrders[0]
        var latestDate: Date = latestOrder.getTime()

        // TODO wrap in async task and update view when the latest order is determined
        // iterate through all the orders
        for (order in provinceOrders) {
            // update the latest order if the current one is newer
            if (order.getTime() > latestDate) {
                latestOrder = order
                latestDate = order.getTime()
            }
        }
        return latestOrder
    }

}