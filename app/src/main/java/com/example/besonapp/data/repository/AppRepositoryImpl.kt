package com.example.besonapp.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.example.besonapp.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor (
    private val dataStore: DataStore<Preferences>
): AppRepository {

    override suspend fun setUserOpenAppOnceFlagForShowSplashAndIntroScreens() {
        dataStore.edit { user_preferences ->
            user_preferences[booleanPreferencesKey("isUserOpenAppOnce")] = true
        }
    }

    override suspend fun getUserOpenAppOnceFlag(): Flow<Boolean> {
        val key = booleanPreferencesKey("isUserOpenAppOnce")
        val data = dataStore.data.map{
            it[key] ?: false
        }
        return data
    }

    override suspend fun setUserPassTutorialOnceFlag() {
        dataStore.edit { user_preferences ->
            user_preferences[booleanPreferencesKey("isUserPassTutorialOnce")] = true
        }
    }

    override suspend fun getUserPassTutorialOnceFlag(): Flow<Boolean> {
        val key = booleanPreferencesKey("isUserPassTutorialOnce")
        val data = dataStore.data.map{
            it[key] ?: false
        }
        return data
    }
}