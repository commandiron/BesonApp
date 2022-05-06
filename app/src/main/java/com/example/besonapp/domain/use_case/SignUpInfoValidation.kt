package com.example.besonapp.domain.use_case

import com.example.besonapp.util.SignUpAndLogInInfoValidation
import com.example.besonapp.util.UserSignUpInfo

class SignUpInfoValidation {
    fun invoke(userSignUpInfo: UserSignUpInfo): SignUpAndLogInInfoValidation {
        return SignUpAndLogInInfoValidation().invokeForSignUp(userSignUpInfo)
    }
}