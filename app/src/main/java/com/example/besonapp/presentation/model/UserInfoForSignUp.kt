package com.example.besonapp.presentation.model

import com.example.besonapp.util.SignUpTextFieldErrorTexts.EMPTY_TEXT_FIELD_ERROR_MESSAGE
import com.example.besonapp.util.SignUpTextFieldErrorTexts.LEAST_EIGHT_CHAR_EMAIL_ERROR_MESSAGE
import com.example.besonapp.util.SignUpTextFieldErrorTexts.NOT_SAME_PASSWORD_ERROR_MESSAGE
import com.example.besonapp.util.SignUpTextFieldErrorTexts.WRONG_EMAIL_REGEX_ERROR_MESSAGE
import java.util.regex.Pattern

data class UserInfoForSignUp(
    var email: String,
    var password: String = "",
    var passwordAgain: String = ""
) {
    fun getUserInfoForSignUpTextFieldError(): UserInfoForSignUpTextFieldError {

        val userInfoSignUpError = UserInfoForSignUpTextFieldError()

        val emailAddressRegexPattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"

        if(email.isEmpty()){
            userInfoSignUpError.emailError = true
            userInfoSignUpError.emailErrorMessage = EMPTY_TEXT_FIELD_ERROR_MESSAGE
        }else if(!email.matches(Pattern.compile(emailAddressRegexPattern, Pattern.CASE_INSENSITIVE).toRegex())){
            userInfoSignUpError.emailError = true
            userInfoSignUpError.emailErrorMessage = WRONG_EMAIL_REGEX_ERROR_MESSAGE
        }else{
            userInfoSignUpError.emailError = false
            userInfoSignUpError.emailErrorMessage = ""
        }
        if(password.isEmpty() || passwordAgain.isEmpty()){
            userInfoSignUpError.passwordError = true
            userInfoSignUpError.passwordErrorMessage = EMPTY_TEXT_FIELD_ERROR_MESSAGE
        }else if(password != passwordAgain){
            userInfoSignUpError.passwordError = true
            userInfoSignUpError.passwordErrorMessage = NOT_SAME_PASSWORD_ERROR_MESSAGE
        }else{
            if(password.length < 8){
                userInfoSignUpError.passwordError = true
                userInfoSignUpError.passwordErrorMessage = LEAST_EIGHT_CHAR_EMAIL_ERROR_MESSAGE
            }else{
                userInfoSignUpError.passwordError = false
                userInfoSignUpError.passwordErrorMessage = ""
            }
        }

        return userInfoSignUpError
    }
}

class UserInfoForSignUpTextFieldError(
    var emailError: Boolean = false,
    var emailErrorMessage: String = "",
    var passwordError: Boolean = false,
    var passwordErrorMessage: String = "",
) {
}