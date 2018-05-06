package com.shopifyorders

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.shopifyorders.presentation.SelectCategoryView

class MainActivity : AppCompatActivity() {
    val fragManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // replaces the frame with the selection screen fragment
        val transaction = fragManager.beginTransaction()
                .replace(R.id.content_frame, SelectCategoryView())
        transaction.commit()
    }


}
