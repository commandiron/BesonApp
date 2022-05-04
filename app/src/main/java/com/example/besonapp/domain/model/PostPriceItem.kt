package com.example.besonapp.domain.model

data class PostPriceItem(
    val postId: Int,
    val itemId: Int,
    val title: String,
    val unit: String,
    val price: Double,
    val location: String,
    var date: Long,
    var userById: Int,
    var userByName: String
) {
}