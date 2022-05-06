package com.example.besonapp.domain.use_case

import com.example.besonapp.domain.repository.AppRepository

class SignUp(
    private val repository: AppRepository
) {
    suspend operator fun invoke(email: String, password: String) = repository.signUp(email, password)
}