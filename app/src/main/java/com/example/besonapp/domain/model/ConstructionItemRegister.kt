package com.example.besonapp.domain.model

data class ConstructionItemRegister(
    val id: Int,
    val lowerPrice: Double,
    val upperPrice: Double,
    val quantity: Double = 1.0,
    val materialType: String? = null,
    val brandModelType: String? = null,
    val measurementType: String? = null,
    val additionalDefinition: String,
    val location: String,
)
