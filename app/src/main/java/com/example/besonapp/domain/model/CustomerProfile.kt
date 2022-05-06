package com.example.besonapp.domain.model

import com.example.besonapp.presentation.model.UserType

data class CustomerProfile(
    val profileUid: String,
    val name: String,
    val phoneNumber: String,
    var userProfilePictureUrl: String
) {
}