package com.example.besonapp.domain.use_case

import com.example.besonapp.domain.repository.AppRepository

class SetUserOpenAppOnceFlagForShowSplashAndIntroScreens(
    private val repository: AppRepository
) {
    suspend operator fun invoke() = repository.setUserOpenAppOnceFlagForShowSplashAndIntroScreens()
}