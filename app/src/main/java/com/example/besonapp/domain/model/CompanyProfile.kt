package com.example.besonapp.domain.model

import com.example.besonapp.presentation.model.SubConstructionItem

data class CompanyProfile(
    val name: String,
    val phoneNumber: String,
    val profilePictureUrl: String,
    val mainConstructionItemId: Int,
    val subConstructionItemIdList: List<Int>
) {
}