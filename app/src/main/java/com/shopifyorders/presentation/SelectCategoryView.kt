package com.shopifyorders.presentation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.shopifyorders.R
import com.shopifyorders.presentation.orderprovince.OrderProvinceView
import com.shopifyorders.presentation.orderyear.OrderYearView
import kotlinx.android.synthetic.main.select_category.view.*

class SelectCategoryView : Fragment() {
    val FRAGMENT_TITLE = "Orders"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        var rootview = inflater.inflate(R.layout.select_category, container, false)
        // add onclick listeners to the buttons
        rootview.open_province_button.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(context, "Display by province", Toast.LENGTH_SHORT)
                        .show()
                // open the sort by province fragment
                val transaction = fragmentManager!!.beginTransaction()
                        .replace(R.id.content_frame, OrderProvinceView())
                transaction.addToBackStack("")
                transaction.commit()
            }
        )
        rootview.open_year_button.setOnClickListener(
                View.OnClickListener {
                    Toast.makeText(context, "Display by year", Toast.LENGTH_SHORT)
                            .show()
                    // open the sort by province fragment
                    val transaction = fragmentManager!!.beginTransaction()
                            .replace(R.id.content_frame, OrderYearView())
                    transaction.addToBackStack("")
                    transaction.commit()
                }
        )

        return rootview
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            activity!!.title = FRAGMENT_TITLE
        }
    }
}