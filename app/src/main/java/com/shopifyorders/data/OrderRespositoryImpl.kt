package com.shopifyorders.data

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.shopifyorders.domain.Order
import com.shopifyorders.domain.OrderImpl
import com.shopifyorders.presentation.orderprovince.OrderProvincePresenter
import com.shopifyorders.presentation.orderyear.OrderYearPresenter
import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.json.simple.parser.ParseException
import java.text.SimpleDateFormat
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
                    response -> val orderList = parseJSON(response)
                    // send all the orders to the presenter to get parsed
                    orderProvincePresenter.receiveOrders(orderList)
                },
                Response.ErrorListener {
                    error ->  Log.d(cTAG, error.message)
                })
        // adds the request to the queue to be executed
        reqQueue.add(request)
    }

    override fun retreiveOrderYear (orderYearPresenter: OrderYearPresenter) {
        // attach listeners to the request
        val request = StringRequest(Request.Method.GET, cENDPOINT,
                Response.Listener<String> {
                    // calls the method to parse the JSON response
                    response -> val orderList = parseJSON(response)
                    // send all the orders to the presenter to get parsed
                    orderYearPresenter.receiveOrders(orderList)
                },
                Response.ErrorListener {
                    error ->  Log.d(cTAG, error.message)
                })
        // adds the request to the queue to be executed
        reqQueue.add(request)
    }


    private fun parseJSON(responseText: String) : List<Order>{
        val stringToDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
        val orderList : ArrayList<Order> = ArrayList()

        try {
            Log.d(cTAG, responseText)
            val responseObject = jsonParser.parse(responseText) as JSONObject
            val ordersArray = responseObject.get("orders") as JSONArray

            // creates an iterator for the orders using its keys
            val orderIterator = ordersArray.iterator()

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
        }
        catch (e: ParseException) {
            Log.d(cTAG, e.message)
        }

        return orderList
    }







}