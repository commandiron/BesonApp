package com.example.besonapp.presentation.model

data class ConstructionPriceItem(
    val itemId: Int? = null,
    val title: String,
    val unit: String,
    val price: Double? = null,
    val location: String = "İstanbul",
    var date: Long = 0,
    var userById: Int? = null,
    var userByName: String = "Emir Demirli"
)