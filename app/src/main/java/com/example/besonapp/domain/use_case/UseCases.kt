package com.example.besonapp.domain.use_case

data class UseCases(

    val setUserOpenAppOnceFlagForShowSplashAndIntroScreens: SetUserOpenAppOnceFlagForShowSplashAndIntroScreens,
    val getUserOpenAppOnceFlag: GetUserOpenAppOnceFlag,

    val signUpInfoValidation: SignUpInfoValidation,
    val logInInfoValidation: LogInInfoValidation,

    val signUp: SignUp,
    val createUserProfileToFirebaseDb: CreateUserProfileToFirebaseDb,
    val logIn: LogIn,

    val setUserPassTutorialOnceFlag: SetUserPassTutorialOnceFlag,
    val getUserPassTutorialOnceFlag: GetUserPassTutorialOnceFlag,

    val uploadProfilePictureToFirebaseStorage: UploadProfilePictureToFirebaseStorage,
    val updateCustomerProfileToFirebaseDb: UpdateCustomerProfileToFirebaseDb
) {
}