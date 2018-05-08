//package com.shopifyorders.data.datamodel.order
//
//import android.arch.persistence.room.Database
//import android.arch.persistence.room.Room
//import android.arch.persistence.room.RoomDatabase
//import android.content.Context
//import android.util.Log
//import com.android.volley.Request
//import com.android.volley.RequestQueue
//import com.android.volley.Response
//import com.android.volley.toolbox.StringRequest
//import com.android.volley.toolbox.Volley
//import com.shopifyorders.domain.Order
//import com.shopifyorders.domain.OrderImpl
//import org.json.simple.JSONArray
//import org.json.simple.JSONObject
//import org.json.simple.parser.JSONParser
//import org.json.simple.parser.ParseException
//import java.io.File
//import java.text.SimpleDateFormat
//
//@Database(entities = [OrderMapper::class], version = 0, exportSchema = false)
//abstract class OrderDatabase : RoomDatabase (){
//    // Endpoint for API is here for brevity
//    private val cENDPOINT = "https://shopicruit.myshopify.com/admin/orders.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6"
//    val TAG = "ORDER_DATABASE"
//
//    var reqQueue :RequestQueue? = null
//    val jsonParser: JSONParser = JSONParser()
//
//    abstract fun orderDao(): OrderDao
//
//    companion object {
//        val DB_NAME = "Order Database"
//        var INSTANCE: OrderDatabase? = null
//
//        fun getInstance (context: Context) : OrderDatabase {
//            // checks if the database has been initialized
//            val currentDB : File = context.getDatabasePath(DB_NAME)
//
//            // create a new instance of the database
//            INSTANCE = Room.databaseBuilder(context.applicationContext,
//                    OrderDatabase::class.java, DB_NAME).build()
//
//            // initialize the database if it hasn't already been done
//            if (!currentDB.exists()) {
//                INSTANCE!!.initializeDatabase(context)
//            }
//            return INSTANCE!!
//        }
//
//        fun destroyInstance () {
//            INSTANCE = null
//        }
//    }
//
//    /**
//     * Initializes the data in the Room Database by making an api call
//     */
//    fun initializeDatabase(context: Context) {
//        reqQueue = Volley.newRequestQueue(context)
//
//        // attach listeners to the request
//        val request = StringRequest(Request.Method.GET, cENDPOINT,
//                Response.Listener<String> {
//                    // calls the method to parse the JSON response
//                    response -> val list = parseJSON(response)
//                },
//                Response.ErrorListener {
//                    error ->  Log.d(TAG, error.message)
//                })
//        // adds the request to the queue to be executed
//        reqQueue!!.add(request)
//    }
//
//
//    /**
//     * parses response from request to insert orders into the database
//     */
//    private fun parseJSON(responseText: String) {
//        val stringToDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
//        try {
//            Log.d(TAG, responseText)
//            val responseObject = jsonParser.parse(responseText) as JSONObject
//            val ordersArray = responseObject.get("orders") as JSONArray
//
//            // creates an iterator for the orders using its keys
//            val orderIterator = ordersArray.iterator()
//            var orderList = ArrayList<Order> ()
//
//            while (orderIterator.hasNext()) {
//                val order = orderIterator.next() as JSONObject
//
//                val productID = order.get("id").toString()
//                val created = order.get("created_at").toString()
//                val createdDate = stringToDate.parse(created.substring(0, 16))
//
//                var provinceCode = ""
//                val province = order.get("shipping_address")
//                if (province != null) {
//                    provinceCode = (province as JSONObject).get("province").toString()
//                }
//
//                Log.d(TAG,
//                        "product = " + productID
//                                + ", date = " + createdDate.toString()
//                                + ", province code = " + provinceCode )
//
//                orderList.add(OrderImpl(productID, provinceCode, createdDate))
//            }
//            INSTANCE!!.orderDao().insertOrders(orderList)
//        }
//        catch (e: ParseException) {
//            Log.d(TAG, e.message)
//        }
//    }
//
//}