package com.example.besonapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.besonapp.data.repository.AppRepositoryImpl
import com.example.besonapp.domain.repository.AppRepository
import com.example.besonapp.domain.use_case.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideFirebaseAuthInstance() = FirebaseAuth.getInstance()

    @Provides
    fun provideFirebaseDatabaseInstance() =
        FirebaseDatabase
            .getInstance("https://besonapp-default-rtdb.europe-west1.firebasedatabase.app/")

    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext appContext: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = { appContext.preferencesDataStoreFile("user_preferences")})
    }

    @Provides
    fun provideRepository(
        auth: FirebaseAuth,
        dataStore: DataStore<Preferences>,
        databaseFirebase: FirebaseDatabase
    ): AppRepository = AppRepositoryImpl(auth, dataStore, databaseFirebase)

    @Provides
    fun provideUseCases(repository: AppRepository) = UseCases(
        setUserOpenAppOnceFlagForShowSplashAndIntroScreens = SetUserOpenAppOnceFlagForShowSplashAndIntroScreens(repository),
        getUserOpenAppOnceFlag = GetUserOpenAppOnceFlag(repository),
        signUpInfoValidation = SignUpInfoValidation(),
        logInInfoValidation = LogInInfoValidation(),
        signUp = SignUp(repository),
        createUserProfileToFirebaseDb = CreateUserProfileToFirebaseDb(repository),
        logIn = LogIn(repository),
        setUserPassTutorialOnceFlag = SetUserPassTutorialOnceFlag(repository),
        getUserPassTutorialOnceFlag = GetUserPassTutorialOnceFlag(repository)
    )

}