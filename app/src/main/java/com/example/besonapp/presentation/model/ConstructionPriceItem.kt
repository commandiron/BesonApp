package com.example.besonapp.presentation.model

data class ConstructionPriceItem(
    val id: Int? = null,
    val title: String,
    val unit: String,
    val price: Double? = null,
    val includeVat: Boolean = false
)