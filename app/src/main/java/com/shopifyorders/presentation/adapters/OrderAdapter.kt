package com.shopifyorders.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.shopifyorders.R
import com.shopifyorders.domain.Item
import com.shopifyorders.domain.Order
import kotlinx.android.synthetic.main.order_item.view.*
import java.text.SimpleDateFormat

class OrderAdapter (val orderList : List<Order>)
    : RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder (itemView) {
        // stores references to views for each order item view
        val orderItemQuantity = itemView.order_item_total_quantity as TextView
        val orderItems = itemView.year_order_items as TextView
        val orderPrice = itemView.order_item_price as TextView
        val orderTimeLocation = itemView.year_order_item_date_location as TextView
        val moreItemsIcon = itemView.order_item_more_items_icon as ImageView
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holderView = LayoutInflater.from(parent.context)
                .inflate(R.layout.order_item, parent, false)

        return ViewHolder(holderView)
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentOrder = orderList.get(position)

        // get order items and convert it into the a string to be displayed
        val ordersItemsRep = StringBuilder()
        val orderItems : List<Item> = currentOrder.getOrderItems()

        if (orderItems.size <= 1) {
            // display the number and title of the single item
            val item = orderItems.get(0)
            if (item.getQuantity() == 1) {

            }
            ordersItemsRep.append(item.getQuantity().toString() + " " + item.getName())

        } else {
            // display the total number of items ordered instead
            var totalItems = 0
            var differentItems = 0
            for (item in orderItems) {
                differentItems += 1
                totalItems += item.getQuantity()
            }
            ordersItemsRep.append(totalItems.toString() + " items total\n"
                    + differentItems.toString() + " different items")
        }

        holder.orderItems.text = ordersItemsRep.toString()
        holder.orderItemQuantity.text = orderItems.size.toString().plus(" items")

        //holder.orderQuantity.text = currentOrder.getProvinceCode()
        holder.orderPrice.text = currentOrder.getTotal().toString()
                .plus(" " + currentOrder.getOrderCurrency())

        holder.orderTimeLocation.text = SimpleDateFormat("'At' yyyy/MM/dd")
                .format(currentOrder.getLastModified())
                .plus(" from " + currentOrder.getProvinceCode())
    }




}