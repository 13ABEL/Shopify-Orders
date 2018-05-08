package com.shopifyorders.presentation.orderyear

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shopifyorders.R

class OrderYearTab : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        var rootview = inflater.inflate(R.layout.year_orders_tab, container, false)


        return rootview
    }


}