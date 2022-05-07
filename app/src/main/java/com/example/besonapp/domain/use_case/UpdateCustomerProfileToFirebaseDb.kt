package com.example.besonapp.domain.use_case

import com.example.besonapp.domain.model.CustomerProfile
import com.example.besonapp.domain.repository.AppRepository

class UpdateCustomerProfileToFirebaseDb(
    private val repository: AppRepository
) {
    suspend operator fun invoke(customerProfile: CustomerProfile)
    = repository.updateCustomerProfileToFirebaseDb(customerProfile)
}