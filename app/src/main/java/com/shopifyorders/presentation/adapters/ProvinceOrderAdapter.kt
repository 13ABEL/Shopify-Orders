package com.shopifyorders.presentation.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shopifyorders.R
import com.shopifyorders.data.datamodel.ProvinceOrderModel
import kotlinx.android.synthetic.main.province_orders_item.view.*

class ProvinceOrderAdapter(var context: Context?)
    : RecyclerView.Adapter<RecyclerView.ViewHolder> () {

    var provinceList : List<ProvinceOrderModel> = ArrayList()

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder (itemView) {
        // initializes the references to the layout
        val province = itemView.province_order_item_province_name as TextView
        val total = itemView.province_order_item_total as TextView
        val recent = itemView.province_order_item_recent as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // inflate the view for the province item and use it to create the view holder
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.province_orders_item, parent, false)

        return ViewHolder(view)
    }

    private fun getItem(position: Int) : ProvinceOrderModel {
        return this.provinceList[position]
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // get the item at the position
        val currentProvince = getItem(position)

        // replace the info held in the viewholder
        val holder = (holder as ViewHolder)
        holder.province.text = currentProvince.getName()
        holder.total.text = "total: " + currentProvince.getTotal().toString() + " orders"
        holder.recent.text = "latest : " +currentProvince.getLatestOrderInfo()
    }

    override fun getItemCount(): Int {
        return provinceList.size
    }

    fun setList(provinceOrders : List<ProvinceOrderModel>) {
        this.provinceList = provinceOrders
    }
}