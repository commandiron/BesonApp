package com.example.besonapp.presentation.screens.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.common_components.CustomButton
import com.example.besonapp.presentation.common_components.CustomTextFieldComponent
import com.example.besonapp.ui.theme.LOWER_VISIBILITY_ALPHA
import com.example.besonapp.util.UserLogInInfo
import com.example.besonapp.util.AppStaticTexts
import com.example.besonapp.util.SignUpAndLogInFormErrorHandle

@Composable
fun LogInFormComponent(
    modifier: Modifier,
    signUpAndLogInFormErrorHandle: SignUpAndLogInFormErrorHandle,
    onSignUpButtonClick:() -> Unit,
    onLogInButtonClick:(UserLogInInfo) -> Unit,

    ){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Beşon'a Giriş Yapın",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h2)

        Spacer(modifier = Modifier.height(28.dp))

        CustomTextFieldComponent(
            entry = email,
            hint = AppStaticTexts.SIGNUP_SCREEN_EMAIL_HINT_TEXT,
            textFieldError = signUpAndLogInFormErrorHandle.emailError,
            textFieldErrorMessage = signUpAndLogInFormErrorHandle.emailErrorMessage,
            keyboardType = KeyboardType.Email){
            email = it
        }

        CustomTextFieldComponent(
            entry = password,
            hint =  AppStaticTexts.SIGNUP_SCREEN_PASSWORD_HINT_TEXT,
            textFieldError = signUpAndLogInFormErrorHandle.passwordError,
            textFieldErrorMessage = signUpAndLogInFormErrorHandle.passwordErrorMessage,
            keyboardType = KeyboardType.Password){
            password = it
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(28.dp))

            CustomButton(
                modifier = Modifier.width(100.dp),
                onClick = {
                    onLogInButtonClick(UserLogInInfo(email, password))
                }
            ) {
                Text(text = "Giriş")
            }

            Spacer(modifier = Modifier.height(40.dp))
            
            Text(
                text = "ya da",
                color = MaterialTheme.colors.onBackground.copy(LOWER_VISIBILITY_ALPHA),
                style = MaterialTheme.typography.body1)

            Spacer(modifier = Modifier.height(40.dp))

            CustomButton(
                modifier = Modifier.width(100.dp),
                onClick = {
                    onSignUpButtonClick()
                }
            ) {
                Text(text = "Kayıt Ol")
            }
        }
    }
}