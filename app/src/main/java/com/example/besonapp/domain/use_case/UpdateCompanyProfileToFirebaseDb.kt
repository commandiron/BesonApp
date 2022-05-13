package com.example.besonapp.domain.use_case

import com.example.besonapp.domain.model.CompanyProfile
import com.example.besonapp.domain.repository.AppRepository

class UpdateCompanyProfileToFirebaseDb(
    private val repository: AppRepository
) {
    suspend operator fun invoke(companyProfile: CompanyProfile)
        = repository.updateCompanyProfileToFirebaseDb(companyProfile)
}