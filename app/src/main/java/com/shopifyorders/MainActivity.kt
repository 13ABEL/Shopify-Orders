package com.shopifyorders

import android.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.shopifyorders.presentation.orderprovince.OrderProvinceView

class MainActivity : AppCompatActivity() {
    val fragManager = supportFragmentManager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add onclick listeners to the buttons
        findViewById<Button>(R.id.open_province_button).setOnClickListener(
            View.OnClickListener {
                Toast.makeText(applicationContext, "Display by province", Toast.LENGTH_SHORT)
                        .show()
                // open the sort by province fragment
                fragManager.beginTransaction().replace(R.id.content_frame, OrderProvinceView())
                        .commit()
            }
        )
    }


}
