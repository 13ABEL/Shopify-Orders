package com.shopifyorders.presentation.orderyear

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shopifyorders.R
import com.shopifyorders.presentation.adapters.YearOrderTabAdapter
import kotlinx.android.synthetic.main.year_orders.view.*

class OrderYearView : Contract.View, Fragment() {
    val presenter : Contract.Presenter = OrderYearPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val rootview = inflater.inflate(R.layout.year_orders, container, false)

        // retrieve the fragment manager to create a new tab adapter
        var yearTabAdapter = YearOrderTabAdapter(this.childFragmentManager)

        // inflates the viewpager and attach the tab adapter to it
        var viewPager = rootview.order_by_year_viewpager
        viewPager.adapter = yearTabAdapter

        // inflates the tablayout and attach the viewpager to it
        var tabLayout = rootview.order_by_year_tablayout
        tabLayout.setupWithViewPager(viewPager)

        return rootview
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            activity!!.title = "Orders By Year"
        }
    }


}