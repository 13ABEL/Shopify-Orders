package com.shopifyorders.presentation.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.shopifyorders.domain.Order
import com.shopifyorders.presentation.orderyear.OrderYearTab

class YearOrderTabAdapter(fragManager : FragmentManager) : FragmentStatePagerAdapter(fragManager) {

    var ordersByYear : MutableList<Order> = ArrayList()

    override fun getCount(): Int {
        return ordersByYear.size
    }

    override fun getItem(position: Int): Fragment {
        return OrderYearTab()
    }
}