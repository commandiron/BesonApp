package com.example.besonapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.besonapp.data.repository.AppRepositoryImpl
import com.example.besonapp.domain.repository.AppRepository
import com.example.besonapp.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext appContext: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = { appContext.preferencesDataStoreFile("user_preferences")})
    }

    @Provides
    fun provideRepository(
        dataStore: DataStore<Preferences>
    ): AppRepository = AppRepositoryImpl(dataStore)

    @Provides
    fun provideUseCases(repository: AppRepository) = UseCases(
        setUserOpenAppOnceFlagForShowSplashAndIntroScreens = SetUserOpenAppOnceFlagForShowSplashAndIntroScreens(repository),
        getUserOpenAppOnceFlag = GetUserOpenAppOnceFlag(repository),
        setUserPassTutorialOnceFlag = SetUserPassTutorialOnceFlag(repository),
        getUserPassTutorialOnceFlag = GetUserPassTutorialOnceFlag(repository)
    )

}