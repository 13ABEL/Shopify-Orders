package com.shopifyorders.presentation.adapters

import android.content.Context
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
        val year : TextView = itemView.order_item_time
        val total : TextView = itemView.order_item_name
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
        val item = yearList.get(position)

        holder.year.text = item.getOrderYear().toString()
    }

    fun setList(yearOrders : List<YearOrderModel>) {
        this.yearList = yearOrders
        Log.d("TAG", yearOrders.size.toString())
    }
}