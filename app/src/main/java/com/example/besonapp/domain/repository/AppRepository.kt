package com.example.besonapp.domain.repository

import kotlinx.coroutines.flow.Flow


interface AppRepository {
    suspend fun setUserOpenAppOnceFlagForShowSplashAndIntroScreens(isUserOpenAppOnce: Boolean)
    suspend fun getUserOpenAppOnceFlag(): Flow<Boolean>
}