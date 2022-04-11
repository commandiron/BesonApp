package com.example.besonapp.presentation.screens.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.common_components.CustomTextFieldComponent
import com.example.besonapp.presentation.model.UserInfoForLogIn
import com.example.besonapp.presentation.model.UserInfoForSignUp
import com.example.besonapp.presentation.model.UserInfoForSignUpTextFieldError
import com.example.besonapp.util.AppStaticTexts

@Composable
fun LogInFormComponent(
    onSignUpButtonClick:() -> Unit,
    onLogInButtonClick:(UserInfoForLogIn) -> Unit,

){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var userInfoSignUpError by remember { mutableStateOf(UserInfoForSignUpTextFieldError())}

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Beşon'a Giriş Yapın",
            style = MaterialTheme.typography.h2)

        Spacer(modifier = Modifier.height(8.dp))

        CustomTextFieldComponent(
            entry = email,
            hint = AppStaticTexts.SIGNUP_SCREEN_EMAIL_HINT_TEXT,
            textFieldError = userInfoSignUpError.emailError,
            textFieldErrorMessage = userInfoSignUpError.emailErrorMessage,
            keyboardType = KeyboardType.Email){
            email = it
        }

        CustomTextFieldComponent(
            entry = password,
            hint =  AppStaticTexts.SIGNUP_SCREEN_PASSWORD_HINT_TEXT,
            keyboardType = KeyboardType.Password){
            password = it
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier.width(200.dp),
                onClick = {
                    userInfoSignUpError = UserInfoForSignUp(email).getUserInfoForSignUpTextFieldError()

                    onLogInButtonClick(UserInfoForLogIn(email, password))
                }
            ) {
                Text(text = "Giriş")
            }

            Spacer(modifier = Modifier.height(40.dp))
            
            Text(text = "ya da")

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                modifier = Modifier.width(200.dp),
                onClick = {
                    onSignUpButtonClick()
                }
            ) {
                Text(text = "Kayıt Ol")
            }
        }
    }
}