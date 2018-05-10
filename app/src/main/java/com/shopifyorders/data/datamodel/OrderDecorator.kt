//package com.shopifyorders.data.datamodel
//
//import android.os.Parcel
//import android.os.Parcelable
//import com.shopifyorders.domain.OrderImpl
//import java.text.SimpleDateFormat
//import java.util.*
//
///**
// *  Decorator to add extended functionality to the the order impl without changing the order impl
// *  class to cross domains and use android specific components
// */
//
//class OrderDecorator () : OrderImpl(), Parcelable {
//    constructor(dorderID: String, dprovince: String, dorderDate:Date) : this()
//
//    // formatter for the date
//    val stringToDate =  SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
//
//    constructor(parcel: Parcel) : this () {
//        val dataList = arrayOfNulls<String>(3)
//        parcel.readStringArray(dataList)
//
//        // retreives values to be placed in the new unpacked object
//        dorderID = dataList.get(0)!!
//        dprovince = dataList.get(1)!!
//        dorderDate = stringToDate.parse(dataList.get(2))!!
//    }
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(orderID)
//        parcel.writeString(province)
//        parcel.writeString(stringToDate.format(orderDate))
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<OrderDecorator> {
//        override fun createFromParcel(parcel: Parcel): OrderDecorator {
//            return OrderDecorator(parcel)
//        }
//
//        override fun newArray(size: Int): Array<OrderDecorator?> {
//            return arrayOfNulls(size)
//        }
//    }
//}