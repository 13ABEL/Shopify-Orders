package com.shopifyorders.data.datamodel.order

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import com.shopifyorders.domain.Order

@Dao
abstract class OrderDao {
    @Insert
    abstract fun insertOrders(orders: List<Order>)

}