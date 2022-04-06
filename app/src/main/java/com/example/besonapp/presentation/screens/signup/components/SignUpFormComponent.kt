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
import com.example.besonapp.presentation.model.UserInfoSignUp
import com.example.besonapp.util.StaticTexts.SIGNUP_SCREEN_EMAIL_HINT_TEXT
import com.example.besonapp.util.StaticTexts.SIGNUP_SCREEN_PASSWORD_AGAIN_HINT_TEXT
import com.example.besonapp.util.StaticTexts.SIGNUP_SCREEN_PASSWORD_HINT_TEXT

@Composable
fun SignUpFormComponent(
    buttonText: String,
    paddingFromBottom: Dp = 0.dp,
    onButtonClick:(UserInfoSignUp) -> Unit,
){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordAgain by remember { mutableStateOf("") }

    var emptyEmailError by remember { mutableStateOf(false)}
    var passwordsNotSameError by remember { mutableStateOf(false)}

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = paddingFromBottom),
        contentAlignment = Alignment.Center) {

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Kayıt Ol",
                style = MaterialTheme.typography.h2)

            CustomTextFieldComponent(
                entry = email,
                hint = SIGNUP_SCREEN_EMAIL_HINT_TEXT,
                textFieldError = emptyEmailError,
                keyboardType = KeyboardType.Email){
                email = it
            }

            CustomTextFieldComponent(
                entry = password,
                hint =  SIGNUP_SCREEN_PASSWORD_HINT_TEXT,
                textFieldError = passwordsNotSameError,
                keyboardType = KeyboardType.Password){
                password = it
            }

            CustomTextFieldComponent(
                entry = passwordAgain,
                hint =  SIGNUP_SCREEN_PASSWORD_AGAIN_HINT_TEXT,
                textFieldError = passwordsNotSameError,
                keyboardType = KeyboardType.Password){
                passwordAgain = it
            }
            
            Button(
                onClick = {
                    emptyEmailError = email.isEmpty()
                    passwordsNotSameError = password != passwordAgain

                    onButtonClick(UserInfoSignUp(email, password, passwordAgain))
                }
            ) {
                Text(text = buttonText)
            }
        }
    }
}