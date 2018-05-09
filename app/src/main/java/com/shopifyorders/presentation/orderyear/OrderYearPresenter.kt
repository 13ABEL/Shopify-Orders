package com.shopifyorders.presentation.orderyear

import android.util.Log
import com.shopifyorders.data.OrderRepository
import com.shopifyorders.data.datamodel.YearOrderModel
import com.shopifyorders.data.datamodel.YearOrderModelImpl
import com.shopifyorders.domain.Order
import java.util.*

class OrderYearPresenter (val view :Contract.View) : Contract.Presenter {
    val TAG = "ORDER_YEAR_PRESENTER"
    val yearOrderList = TreeMap<Int, YearOrderModel>()

    override fun retrieveOrders(orderRepo: OrderRepository) {
         orderRepo.retreiveOrderYear(this)
     }


    override fun receiveOrders(orders: List<Order>) {
        val cal = Calendar.getInstance()
        for (order in orders) {
            // add the year to the set of years
            cal.time = order.getDate()
            val year = cal.get(Calendar.YEAR)
            Log.d(TAG, "year = " + year)

            // create a new year order model if one doesn't exist for the year
            if (yearOrderList.containsKey(year)){
                yearOrderList.get(year)!!.addOrder(order)
            }
            else {
                yearOrderList.put(year, YearOrderModelImpl(year))
            }
        }
        view.displayOrders(yearOrderList.values.toList())
    }

    override fun getYears(): List<Int> {
        return yearOrderList.keys.reversed().toList()
    }

    override fun getYearOrder(year: Int): YearOrderModel {
        return yearOrderList.get(year)!!
    }
}