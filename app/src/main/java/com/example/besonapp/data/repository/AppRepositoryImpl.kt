package com.example.besonapp.data.repository

//@Singleton
//class AppRepositoryImpl @Inject constructor (
//    private val dataStore: DataStore<Preferences>
//): AppRepository {
//
//    override suspend fun setUserOpenAppOnceFlagForShowSplashAndIntroScreens(isUserOpenAppOnce: Boolean) {
//        dataStore.edit { user_preferences ->
//            user_preferences[booleanPreferencesKey("isUserOpenAppOnce")] = isUserOpenAppOnce
//        }
//    }
//
//    override suspend fun getUserOpenAppOnceFlag(): Flow<Boolean> {
//        val key = booleanPreferencesKey("isUserOpenAppOnce")
//        val data = dataStore.data.map{
//            it[key] ?: false
//        }
//        return data
//    }
//}