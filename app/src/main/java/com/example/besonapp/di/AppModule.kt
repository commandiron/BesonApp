package com.example.besonapp.di

//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//
//    @Singleton
//    @Provides
//    fun provideDataStore(@ApplicationContext appContext: Context): DataStore<Preferences>{
//        return PreferenceDataStoreFactory.create(
//            produceFile = { appContext.preferencesDataStoreFile("user_preferences")})
//    }
//
//    @Provides
//    fun provideRepository(
//        dataStore: DataStore<Preferences>
//    ): AppRepository = AppRepositoryImpl(dataStore)
//
//    @Provides
//    fun provideUseCases(repository: AppRepository) = UseCases(
//        setUserOpenAppOnceFlagForShowSplashAndIntroScreens = SetUserOpenAppOnceFlagForShowSplashAndIntroScreens(repository),
//        getUserOpenAppOnceFlag = GetUserOpenAppOnceFlag(repository)
//    )
//
//}