package com.shopifyorders.domain

data class ItemImpl (
        val itemID: String,
        val itemName: String,
        val itemVariantID: String,
        val itemVariantName: String,
        val itemPrice: Double,
        val itemQuantity: Int
    ) : Item