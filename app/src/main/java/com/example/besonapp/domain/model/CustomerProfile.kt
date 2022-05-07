package com.example.besonapp.domain.model

data class CustomerProfile(
    val name: String,
    val phoneNumber: String,
    var profilePictureUrl: String
) {
}