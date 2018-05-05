package com.shopifyorders.data

import com.shopifyorders.presentation.orderprovince.OrderProvincePresenter

interface OrderRepository {
    fun retreiveOrderProvince(presenter: OrderProvincePresenter)
}