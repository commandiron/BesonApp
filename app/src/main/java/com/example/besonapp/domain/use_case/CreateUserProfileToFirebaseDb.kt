package com.example.besonapp.domain.use_case

import com.example.besonapp.domain.repository.AppRepository
import com.example.besonapp.presentation.model.UserType

class CreateUserProfileToFirebaseDb(
    private val repository: AppRepository
) {
    suspend operator fun invoke(userType: UserType) = repository.createUserProfileToFirebaseDb(userType)
}