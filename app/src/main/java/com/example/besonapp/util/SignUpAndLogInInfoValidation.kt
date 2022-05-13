package com.example.besonapp.util

import com.example.besonapp.presentation.model.UserLogInInfo
import com.example.besonapp.presentation.model.UserSignUpInfo
import java.util.regex.Pattern

data class SignUpAndLogInInfoValidation(
    var emailError: Boolean = false,
    var emailErrorMessage: String = "",
    var passwordError: Boolean = false,
    var passwordErrorMessage: String = "",
) {
    fun invokeForSignUp(userSignUpInfo: UserSignUpInfo): SignUpAndLogInInfoValidation {

        val signUpError = SignUpAndLogInInfoValidation()

        val emailAddressRegexPattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"

        if(userSignUpInfo.email.isEmpty()){
            signUpError.emailError = true
            signUpError.emailErrorMessage =
                ErrorTexts.EMPTY_TEXT_FIELD_ERROR_MESSAGE
        }else if(!userSignUpInfo.email.matches(Pattern.compile(emailAddressRegexPattern, Pattern.CASE_INSENSITIVE).toRegex())){
            signUpError.emailError = true
            signUpError.emailErrorMessage =
                ErrorTexts.WRONG_EMAIL_REGEX_ERROR_MESSAGE
        }else{
            signUpError.emailError = false
            signUpError.emailErrorMessage = ""
        }
        if(userSignUpInfo.password.isEmpty() || userSignUpInfo.passwordAgain.isEmpty()){
            signUpError.passwordError = true
            signUpError.passwordErrorMessage =
                ErrorTexts.EMPTY_TEXT_FIELD_ERROR_MESSAGE
        }else if(userSignUpInfo.password != userSignUpInfo.passwordAgain){
            signUpError.passwordError = true
            signUpError.passwordErrorMessage =
                ErrorTexts.NOT_SAME_PASSWORD_ERROR_MESSAGE
        }else{
            if(userSignUpInfo.password.length < 6){
                signUpError.passwordError = true
                signUpError.passwordErrorMessage =
                    ErrorTexts.LEAST_EIGHT_CHAR_EMAIL_ERROR_MESSAGE
            }else{
                signUpError.passwordError = false
                signUpError.passwordErrorMessage = ""
            }
        }
        return signUpError
    }

    fun invokeForLogIn(userLogInInfo: UserLogInInfo): SignUpAndLogInInfoValidation {

        val logInError = SignUpAndLogInInfoValidation()

        val emailAddressRegexPattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"

        if(userLogInInfo.email.isEmpty()){
            logInError.emailError = true
            logInError.emailErrorMessage =
                ErrorTexts.EMPTY_TEXT_FIELD_ERROR_MESSAGE
        }else if(!userLogInInfo.email.matches(Pattern.compile(emailAddressRegexPattern, Pattern.CASE_INSENSITIVE).toRegex())){
            logInError.emailError = true
            logInError.emailErrorMessage =
                ErrorTexts.WRONG_EMAIL_REGEX_ERROR_MESSAGE
        }else{
            logInError.emailError = false
            logInError.emailErrorMessage = ""
        }
        if(userLogInInfo.password.isEmpty()){
            logInError.passwordError = true
            logInError.passwordErrorMessage =
                ErrorTexts.EMPTY_TEXT_FIELD_ERROR_MESSAGE
        }else{
            if(userLogInInfo.password.length < 6){
                logInError.passwordError = true
                logInError.passwordErrorMessage =
                    ErrorTexts.LEAST_EIGHT_CHAR_EMAIL_ERROR_MESSAGE
            }else{
                logInError.passwordError = false
                logInError.passwordErrorMessage = ""
            }
        }
        return logInError
    }
}

object ErrorTexts {
    const val EMPTY_TEXT_FIELD_ERROR_MESSAGE = "Boş bıraktınız."
    const val WRONG_EMAIL_REGEX_ERROR_MESSAGE = "Doğru bir Eposta adresi giriniz."
    const val LEAST_EIGHT_CHAR_EMAIL_ERROR_MESSAGE = "En az 6 karakter giriniz."
    const val NOT_SAME_PASSWORD_ERROR_MESSAGE = "Aynı değil."
}