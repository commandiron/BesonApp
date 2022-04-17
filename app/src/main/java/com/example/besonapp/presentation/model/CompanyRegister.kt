package com.example.besonapp.presentation.model

data class CompanyRegister(
    val nameOrCompanyName: String = "",
    val phoneNumber: String = "",
    val profilePictureUri: String = "",
    val selectedSubCategoryList: List<ConstructionItem>
)