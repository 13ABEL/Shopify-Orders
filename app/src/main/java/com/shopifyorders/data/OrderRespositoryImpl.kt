package com.shopifyorders.data

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.simple.parser.JSONParser
import org.json.simple.parser.ParseException


class OrderRespositoryImpl(mContext: Context) : OrderRepository {
    private val cTAG = "ORDER_REPOSITORY"

    // Endpoint for API is here for brevity
    private val cENDPOINT = "https://shopicruit.myshopify.com/admin/orders.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6"

    private var reqQueue: RequestQueue
    private val parser: JSONParser

    init {
        // initialize the Volley queue
        reqQueue = Volley.newRequestQueue(mContext)
        parser = JSONParser()
    }


    override fun retreiveOrderProvince () {
        // attach listeners to the request
        val request = StringRequest(Request.Method.GET, cENDPOINT,
                Response.Listener<String> {
                    // calls the method to parse the JSON response
                    response -> parseJSON(response)
                },
                Response.ErrorListener {
                    error ->  Log.d(cTAG, error.message)
                })
        // adds the request to the queue to be excecuted
        reqQueue.add(request)
    }

    private fun parseJSON(responseText: String) {
        try {
            Log.d(cTAG, responseText)
            var jsonObject = parser.parse(responseText)
        }
        catch (e: ParseException) {
            Log.d(cTAG, e.message)
        }
    }

}