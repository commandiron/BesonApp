package com.example.besonapp.domain.use_case

data class UseCases(

    val setUserOpenAppOnceFlagForShowSplashAndIntroScreens: SetUserOpenAppOnceFlagForShowSplashAndIntroScreens,
    val getUserOpenAppOnceFlag: GetUserOpenAppOnceFlag,

    val signUpInfoValidation: SignUpInfoValidation,

    val signUp: SignUp,
    val createUserProfileToFirebaseDb: CreateUserProfileToFirebaseDb,

    val setUserPassTutorialOnceFlag: SetUserPassTutorialOnceFlag,
    val getUserPassTutorialOnceFlag: GetUserPassTutorialOnceFlag,
) {
}