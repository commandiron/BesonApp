package com.example.besonapp.domain.use_case

import com.example.besonapp.presentation.model.UserLogInInfo
import com.example.besonapp.presentation.model.UserSignUpInfo
import com.example.besonapp.util.SignUpAndLogInInfoValidation


class LogInInfoValidation {
    fun invoke(userLogInInfo: UserLogInInfo): SignUpAndLogInInfoValidation {
        return SignUpAndLogInInfoValidation().invokeForLogIn(userLogInInfo)
    }
}