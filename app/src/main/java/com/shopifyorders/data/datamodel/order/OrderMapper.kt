//package com.shopifyorders.data.datamodel.order
//
//import android.os.Parcel
//import android.os.Parcelable
//import com.shopifyorders.data.datamodel.OrderDecorator
//import com.shopifyorders.domain.Order
//import com.shopifyorders.domain.OrderImpl
//import java.text.SimpleDateFormat
//
//class OrderMapper (order: Order) : Parcelable {
//    // formatter for the date
//    val stringToDate =  SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
//
//    // map the order values to this parcelable object
//    var orderID = ""
//    var province = order.getProvinceCode()
//    var orderDate = order.getDate()
//
//    fun getOrder() : Order {
//        return OrderImpl(orderID, province, orderDate)
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
//
//}