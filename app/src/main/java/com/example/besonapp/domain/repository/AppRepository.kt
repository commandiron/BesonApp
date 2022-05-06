package com.example.besonapp.domain.repository

import kotlinx.coroutines.flow.Flow


interface AppRepository {
    suspend fun setUserOpenAppOnceFlagForShowSplashAndIntroScreens()
    suspend fun getUserOpenAppOnceFlag(): Flow<Boolean>

    suspend fun setUserPassTutorialOnceFlag()
    suspend fun getUserPassTutorialOnceFlag(): Flow<Boolean>
}