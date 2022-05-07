package com.example.besonapp.presentation.common_components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.model.UserSignUpInfo
import com.example.besonapp.util.AppStaticTexts.EMAIL_TEXT
import com.example.besonapp.util.AppStaticTexts.PASSWORD_AGAIN_TEXT
import com.example.besonapp.util.AppStaticTexts.PASSWORD_TEXT
import com.example.besonapp.util.AppStaticTexts.SIGNUP_TEXT
import com.example.besonapp.util.SignUpAndLogInInfoValidation

@Composable
fun SignUpFormComponent(
    buttonText: String,
    paddingFromBottom: Dp = 0.dp,
    signUpAndLogInInfoValidation: SignUpAndLogInInfoValidation?,
    onButtonClick:(UserSignUpInfo) -> Unit,
){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordAgain by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = paddingFromBottom),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = SIGNUP_TEXT,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h2)

        CustomTextFieldComponent(
            entry = email,
            hint = EMAIL_TEXT,
            textFieldError = signUpAndLogInInfoValidation?.emailError ?: false,
            textFieldErrorMessage = signUpAndLogInInfoValidation?.emailErrorMessage ?: "",
            keyboardType = KeyboardType.Email){
            email = it
        }

        CustomTextFieldComponent(
            entry = password,
            hint =  PASSWORD_TEXT,
            textFieldError = signUpAndLogInInfoValidation?.passwordError ?: false,
            textFieldErrorMessage = signUpAndLogInInfoValidation?.passwordErrorMessage ?: "",
            keyboardType = KeyboardType.Password){
            password = it
        }

        CustomTextFieldComponent(
            entry = passwordAgain,
            hint =  PASSWORD_AGAIN_TEXT,
            textFieldError = signUpAndLogInInfoValidation?.passwordError ?: false,
            textFieldErrorMessage = signUpAndLogInInfoValidation?.passwordErrorMessage ?: "",
            keyboardType = KeyboardType.Password){
            passwordAgain = it
        }

        CustomButton(
            onClick = {

                onButtonClick(UserSignUpInfo(email, password, passwordAgain))
            }
        ) {
            Text(text = buttonText)
        }
    }
}