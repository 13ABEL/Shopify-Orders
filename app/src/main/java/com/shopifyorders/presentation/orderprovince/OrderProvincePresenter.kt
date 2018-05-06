package com.shopifyorders.presentation.orderprovince

import android.util.Log
import com.shopifyorders.data.OrderRepository
import com.shopifyorders.data.datamodel.Order
import com.shopifyorders.data.datamodel.ProvinceOrderModel
import com.shopifyorders.data.datamodel.ProvinceOrderModelImpl
import java.util.*

class OrderProvincePresenter(val view: Contract.View) : Contract.Presenter{
    val cTAG = "OrderProvince_Presenter"
    // Tree mpa because it sorts alphabetically by default
    var provinceOrders = TreeMap<String, ProvinceOrderModel>()

    override fun retrieveOrders(orderRepo: OrderRepository) {
        orderRepo.retreiveOrderProvince(this)
    }

    override fun receiveOrders(orders: List<Order>) {
        // iterate through the received provinces
        for (newOrder in orders) {
            // get the province and sort it into the appropriate province order
            var provinceCode = newOrder.getProvinceCode()

            // adds the order to the set of province orders
            if (provinceOrders.containsKey(provinceCode)) {
                provinceOrders.get(provinceCode)!!.addOrder(newOrder)
            }
            else {
                // initialize the province order for this province
                provinceOrders.put(provinceCode, ProvinceOrderModelImpl(provinceCode))
            }
        }
        Log.d(cTAG, orders.toString())

        // sends the list rep of the map to the view to be displayed
        view.displayProvinceOrders(provinceOrders.values.toList())
    }

}