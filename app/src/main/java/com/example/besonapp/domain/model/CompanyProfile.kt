package com.example.besonapp.domain.model

import com.example.besonapp.presentation.model.SubConstructionItem

data class CompanyProfile(
    val profileUid: String,
    val name: String,
    val phoneNumber: String,
    val userProfilePictureUrl: String,
    val mainConstructionItemId: Int,
    val subConstructionItemId: Int
) {
}