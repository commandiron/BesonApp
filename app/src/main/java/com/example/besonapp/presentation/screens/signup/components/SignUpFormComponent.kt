package com.example.besonapp.presentation.common_components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.model.UserInfoForSignUp
import com.example.besonapp.presentation.model.UserInfoForSignUpTextFieldError
import com.example.besonapp.util.AppStaticTexts
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_EMAIL_HINT_TEXT
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_FORM_TITLE_TEXT
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_PASSWORD_AGAIN_HINT_TEXT
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_PASSWORD_HINT_TEXT

@Composable
fun SignUpFormComponent(
    buttonText: String,
    paddingFromBottom: Dp = 0.dp,
    onButtonClick:(UserInfoForSignUp) -> Unit,
){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordAgain by remember { mutableStateOf("") }

    var userInfoSignUpError by remember { mutableStateOf(UserInfoForSignUpTextFieldError())}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = paddingFromBottom),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = SIGNUP_SCREEN_FORM_TITLE_TEXT,
            style = MaterialTheme.typography.h2)

        CustomTextFieldComponent(
            entry = email,
            hint = SIGNUP_SCREEN_EMAIL_HINT_TEXT,
            textFieldError = userInfoSignUpError.emailError,
            textFieldErrorMessage = userInfoSignUpError.emailErrorMessage,
            keyboardType = KeyboardType.Email){
            email = it
        }

        CustomTextFieldComponent(
            entry = password,
            hint =  SIGNUP_SCREEN_PASSWORD_HINT_TEXT,
            textFieldError = userInfoSignUpError.passwordError,
            textFieldErrorMessage = userInfoSignUpError.passwordErrorMessage,
            keyboardType = KeyboardType.Password){
            password = it
        }

        CustomTextFieldComponent(
            entry = passwordAgain,
            hint =  SIGNUP_SCREEN_PASSWORD_AGAIN_HINT_TEXT,
            textFieldError = userInfoSignUpError.passwordError,
            textFieldErrorMessage = userInfoSignUpError.passwordErrorMessage,
            keyboardType = KeyboardType.Password){
            passwordAgain = it
        }

        Button(
            onClick = {

                userInfoSignUpError = UserInfoForSignUp(email,password,passwordAgain).getUserInfoForSignUpTextFieldError()

                onButtonClick(UserInfoForSignUp(email, password, passwordAgain))
            }
        ) {
            Text(text = buttonText)
        }
    }
}