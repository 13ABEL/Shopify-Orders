//package com.shopifyorders.data.datamodel.order
//
//import android.arch.persistence.room.Dao
//import android.arch.persistence.room.Insert
//import android.arch.persistence.room.Query
//import com.shopifyorders.domain.Order
//
//@Dao
//abstract class OrderDao {
//    @Insert
//    abstract fun insertOrders(orders: List<Order>)
//
//    @Query("SELECT DISTINCT year FROM OrderMapper ")
//    abstract fun getYears() : List<Int>
//}