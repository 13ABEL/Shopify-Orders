package com.shopifyorders.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shopifyorders.R
import com.shopifyorders.domain.Order
import kotlinx.android.synthetic.main.order_item.view.*

class OrderAdapter : RecyclerView.Adapter <RecyclerView.ViewHolder> () {
    val orders : MutableList<Order> = ArrayList()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // initialize the references to placeholders in the itme layout
        val orderName : TextView = itemView.order_item_name
        val orderDate : TextView = itemView.order_item_time
        val orderPrice : TextView = itemView.order_item_price
        val orderQuantity : TextView = itemView.order_item_quantity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.order_item, parent, false)

        // returns the a new viewholder created using this view
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // get the item at the position
        val orderItem : Order = orders[position]

        // bind the item's data to the view

    }


    override fun getItemCount(): Int {
        return orders.size
    }


}