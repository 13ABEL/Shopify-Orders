package com.shopifyorders.presentation.adapters

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shopifyorders.R
import com.shopifyorders.data.datamodel.YearOrderModel
import kotlinx.android.synthetic.main.year_orders_item.view.*

class YearOrderAdapter(var context: Context?)
    : RecyclerView.Adapter<YearOrderAdapter.ViewHolder> () {

    var yearList : List<YearOrderModel> = ArrayList()

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val year : TextView = itemView.year_order_item_name
        val total : TextView = itemView.year_order_item_total

        // get the reference to the recyclerview to create a new adapter for the nested orders
        val ordersRV: RecyclerView = itemView.year_orders_horizontal_recyclerview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YearOrderAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.year_orders_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return yearList.size
    }

    override fun onBindViewHolder(holder: YearOrderAdapter.ViewHolder, position: Int) {
        val yearOrder = yearList.get(position)
        holder.year.text = yearOrder.getOrderYear().toString()
        holder.total.text = yearOrder.getTotal().toString().plus(" orders")

        // attach the adapter to the view
        holder.ordersRV.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.ordersRV.adapter = OrderAdapter(yearOrder.getOrders())
    }

    fun setList(yearOrders : List<YearOrderModel>) {
        this.yearList = yearOrders
        Log.d("TAG", yearOrders.size.toString())
    }
}