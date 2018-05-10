package com.shopifyorders.data.datamodel

import android.os.Parcelable
import com.shopifyorders.domain.Order
import java.util.*
import kotlin.collections.ArrayList

class ProvinceOrderModelImpl(
        var provinceName : String
    ) : ProvinceOrderModel {

    private var provinceOrders : MutableList<Order> = ArrayList()
    private var latestOrder : Order? = null

    override fun getName(): String {
        return this.provinceName
    }

    override fun addOrder(newOrder: Order) {
        this.provinceOrders.add(newOrder)

        if (latestOrder == null || newOrder.getDate().after(latestOrder!!.getDate())) {
            latestOrder = newOrder
        }
    }

    override fun getTotal(): Int {
        return this.provinceOrders.size
    }

    override fun getLatestOrderInfo() : String {
        var currentTime : Long = Date().time
        var differenceString = ""

        // converts latest order to days, hours, or minutes
        if (latestOrder != null) {
            val difference = (currentTime - latestOrder!!.getDate().time)/1000
            if (difference < 60) {
                differenceString = (difference/60).toString() + " minutes ago"
            }
            else if (difference < 60*60) {
                differenceString = (difference/60/60).toString() + " hours ago"
            }
            else {
                differenceString = (difference/60/60/24).toString() + " days ago"
            }
        }

        return differenceString
    }

}