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
import com.example.besonapp.presentation.ui.theme.LOWER_VISIBILITY_ALPHA
import com.example.besonapp.presentation.model.UserLogInInfo
import com.example.besonapp.util.AppStaticTexts.EMAIL_TEXT
import com.example.besonapp.util.AppStaticTexts.LOGIN_BESON_TEXT
import com.example.besonapp.util.AppStaticTexts.LOGIN_TEXT_2
import com.example.besonapp.util.AppStaticTexts.OR_TEXT
import com.example.besonapp.util.AppStaticTexts.PASSWORD_TEXT
import com.example.besonapp.util.AppStaticTexts.SIGNUP_TEXT
import com.example.besonapp.util.SignUpAndLogInInfoValidation

@Composable
fun LogInFormComponent(
    signUpAndLogInInfoValidation: SignUpAndLogInInfoValidation,
    onSignUpButtonClick:() -> Unit,
    onLogInButtonClick:(UserLogInInfo) -> Unit,

    ){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier =  Modifier.fillMaxSize().padding(top = 150.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = LOGIN_BESON_TEXT,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h2)

        Spacer(modifier = Modifier.height(28.dp))

        CustomTextFieldComponent(
            entry = email,
            hint = EMAIL_TEXT,
            textFieldError = signUpAndLogInInfoValidation.emailError,
            textFieldErrorMessage = signUpAndLogInInfoValidation.emailErrorMessage,
            keyboardType = KeyboardType.Email){
            email = it
        }

        CustomTextFieldComponent(
            entry = password,
            hint =  PASSWORD_TEXT,
            textFieldError = signUpAndLogInInfoValidation.passwordError,
            textFieldErrorMessage = signUpAndLogInInfoValidation.passwordErrorMessage,
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
                Text(text = LOGIN_TEXT_2)
            }

            Spacer(modifier = Modifier.height(40.dp))
            
            Text(
                text = OR_TEXT,
                color = MaterialTheme.colors.onBackground.copy(LOWER_VISIBILITY_ALPHA),
                style = MaterialTheme.typography.body1)

            Spacer(modifier = Modifier.height(40.dp))

            CustomButton(
                modifier = Modifier.width(100.dp),
                onClick = {
                    onSignUpButtonClick()
                }
            ) {
                Text(text = SIGNUP_TEXT)
            }
        }
    }
}