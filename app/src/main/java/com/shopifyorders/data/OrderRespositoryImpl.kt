package com.shopifyorders.data

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.shopifyorders.data.datamodel.Order
import com.shopifyorders.data.datamodel.OrderImpl
import com.shopifyorders.data.datamodel.ProvinceOrderModelImpl
import com.shopifyorders.presentation.orderprovince.OrderProvincePresenter
import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.json.simple.parser.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class OrderRespositoryImpl(mContext: Context) : OrderRepository {
    private val cTAG = "ORDER_REPOSITORY"

    // Endpoint for API is here for brevity
    private val cENDPOINT = "https://shopicruit.myshopify.com/admin/orders.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6"

    private val reqQueue = Volley.newRequestQueue(mContext)
    private val jsonParser: JSONParser = JSONParser()

    override fun retreiveOrderProvince (orderProvincePresenter : OrderProvincePresenter) {
        // attach listeners to the request
        val request = StringRequest(Request.Method.GET, cENDPOINT,
                Response.Listener<String> {
                    // calls the method to parse the JSON response
                    response -> val list = parseJSON(response, orderProvincePresenter)
                },
                Response.ErrorListener {
                    error ->  Log.d(cTAG, error.message)
                })
        // adds the request to the queue to be executed
        reqQueue.add(request)
    }


    private fun parseJSON(responseText: String, presenter: OrderProvincePresenter) {
        val stringToDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
        try {
            Log.d(cTAG, responseText)
            val responseObject = jsonParser.parse(responseText) as JSONObject
            val ordersArray = responseObject.get("orders") as JSONArray

            // creates an iterator for the orders using its keys
            val orderIterator = ordersArray.iterator()
            var orderList = ArrayList<Order> ()

            while (orderIterator.hasNext()) {
                val order = orderIterator.next() as JSONObject

                val productID = order.get("id").toString()
                val created = order.get("created_at").toString()
                val createdDate = stringToDate.parse(created.substring(0, 16))

                var provinceCode = ""
                val province = order.get("shipping_address")
                if (province != null) {
                    provinceCode = (province as JSONObject).get("province").toString()
                }

                Log.d(cTAG,
                        "product = " + productID
                        + ", date = " + createdDate.toString()
                        + ", province code = " + provinceCode )

                orderList.add(OrderImpl(productID, provinceCode, createdDate))
            }
            // send all the orders order to the presenter to get parsed
            presenter.receiveOrders(orderList)

        }
        catch (e: ParseException) {
            Log.d(cTAG, e.message)
        }
    }

}