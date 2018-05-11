package com.shopifyorders.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shopifyorders.R
import com.shopifyorders.domain.Order
import kotlinx.android.synthetic.main.order_item.view.*

class OrderAdapter (val orderList : List<Order>)
    : RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder (itemView) {
        val orderQuantity = itemView.order_item_quantity as TextView

        val orderEmail = itemView.year_order_item_email as TextView
        val orderPrice = itemView.order_item_price as TextView

        val orderProvince = itemView.year_order_item_province as TextView
        val orderTime = itemView.year_order_item_date as TextView
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootview = LayoutInflater.from(parent.context)
                .inflate(R.layout.order_item, parent, false)

        return ViewHolder(rootview)
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentOrder = orderList.get(position)
        holder.orderEmail.text = currentOrder.getAuthorEmail()

        //holder.orderQuantity.text = currentOrder.getProvinceCode()
        holder.orderPrice.text = currentOrder.getTotal().toString()
                .plus(" " + currentOrder.getOrderCurrency())

        holder.orderProvince.text = currentOrder.getProvinceCode()
        holder.orderTime.text = currentOrder.getLastModified()
    }


}