package com.example.besonapp.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.presentation.screens.login.components.LogInFormComponent
import com.example.besonapp.util.SignUpAndLogInFormErrorHandle

@Composable
fun LogInScreen(navController: NavController){

    var signUpAndLogInFormErrorHandle by remember { mutableStateOf(SignUpAndLogInFormErrorHandle()) }

    LogInFormComponent(
        modifier = Modifier.padding(top = 150.dp),
        signUpAndLogInFormErrorHandle = signUpAndLogInFormErrorHandle,
        onSignUpButtonClick = {
          navController.navigate(NavigationItem.SignUp.screen_route)
        },
        onLogInButtonClick = {
            signUpAndLogInFormErrorHandle = SignUpAndLogInFormErrorHandle().invokeForLogIn(it) //Bu kısım viewModel'de halledilmeli
        }
    )
}