//package com.shopifyorders.data.datamodel.order
//
//import android.arch.persistence.room.ColumnInfo
//import android.arch.persistence.room.Entity
//import com.shopifyorders.domain.OrderImpl
//import java.util.*
//
//@Entity
//class OrderMapper (orderID: String,
//                   province: String,
//                   orderDate:Date) : OrderImpl(orderID, province, orderDate) {
//    private val cal : Calendar = Calendar.getInstance()
//
//    init {
//        // used for retreiving year property
//        cal.time = orderDate
//    }
//
//    @ColumnInfo(name="year") val orderYear = cal.get(Calendar.YEAR)
//
//
//
//
//
//}