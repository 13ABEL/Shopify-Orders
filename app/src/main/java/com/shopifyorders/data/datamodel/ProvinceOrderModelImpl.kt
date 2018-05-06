package com.shopifyorders.data.datamodel

import java.util.*
import kotlin.collections.ArrayList

class ProvinceOrderModelImpl(
        var provinceName : String
    ) : ProvinceOrderModel {

    var provinceOrders : MutableList<Order> = ArrayList()

    override fun getName(): String {
        return this.provinceName
    }

    override fun addOrder(newOrder: Order) {
        this.provinceOrders.add(newOrder)
    }

    override fun getTotal(): Int {
        return this.provinceOrders.size
    }


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