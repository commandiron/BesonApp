package com.example.besonapp.domain.use_case

data class UseCases(
    val setUserOpenAppOnceFlagForShowSplashAndIntroScreens: SetUserOpenAppOnceFlagForShowSplashAndIntroScreens,
    val getUserOpenAppOnceFlag: GetUserOpenAppOnceFlag,
    val setUserPassTutorialOnceFlag: SetUserPassTutorialOnceFlag,
    val getUserPassTutorialOnceFlag: GetUserPassTutorialOnceFlag
) {
}