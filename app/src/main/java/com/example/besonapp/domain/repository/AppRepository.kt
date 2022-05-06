package com.example.besonapp.domain.repository

import com.example.besonapp.presentation.model.Response
import com.example.besonapp.presentation.model.UserType
import kotlinx.coroutines.flow.Flow


interface AppRepository {
    suspend fun setUserOpenAppOnceFlagForShowSplashAndIntroScreens()
    suspend fun getUserOpenAppOnceFlag(): Flow<Boolean>

    suspend fun setUserPassTutorialOnceFlag()
    suspend fun getUserPassTutorialOnceFlag(): Flow<Boolean>

    suspend fun signUp(email: String, password: String): Flow<Response<Boolean>>
    suspend fun createUserProfileToFirebaseDb(userType: UserType): Flow<Response<Boolean>>
}