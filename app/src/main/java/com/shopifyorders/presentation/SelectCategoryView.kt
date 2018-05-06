package com.shopifyorders.presentation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.shopifyorders.R
import com.shopifyorders.presentation.orderprovince.OrderProvinceView
import kotlinx.android.synthetic.main.select_category.view.*

class SelectCategoryView : Fragment() {
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
                    transaction.addToBackStack("test")
                    transaction.commit()
                }
        )

        return rootview
    }
}