package com.shopifyorders.presentation.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shopifyorders.R
import com.shopifyorders.data.datamodel.ProvinceOrderModel
import kotlinx.android.synthetic.main.province_orders_item.view.*

class ProvinceOrderAdapter(var context: Context?)
    : RecyclerView.Adapter<RecyclerView.ViewHolder> () {

    var provinceList : List<ProvinceOrderModel> = ArrayList()

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder (itemView) {
        // initializes the references to the layout
        val province = itemView.province_order_item_province_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // inflate the view for the province item and use it to create the view holder
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.province_orders_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // replace the info held in the viewholder
        (holder as ViewHolder).province.text = "test"
    }

    override fun getItemCount(): Int {
        return provinceList.size
    }

    fun setList(provinceOrders : List<ProvinceOrderModel>) {
        this.provinceList = provinceOrders
    }
}