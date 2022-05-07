package com.example.besonapp.domain.use_case

import com.example.besonapp.domain.repository.AppRepository

class LogIn(
    private val repository: AppRepository
) {
    suspend operator fun invoke(email: String, password: String) = repository.logIn(email, password)
}