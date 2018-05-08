package com.shopifyorders.data

import com.shopifyorders.presentation.orderprovince.OrderProvincePresenter
import com.shopifyorders.presentation.orderyear.OrderYearPresenter

interface OrderRepository {
    fun retreiveOrderProvince(presenter: OrderProvincePresenter)
    fun retreiveOrderYear(presenter: OrderYearPresenter)


    //fun retreiveOrdersByYear()
}