package com.example.besonapp.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.besonapp.presentation.screens.login.LogInViewModel
import com.example.besonapp.presentation.ui.navigation.NavigationItem
import com.example.besonapp.presentation.screens.login.components.LogInFormComponent

@Composable
fun LogInScreen(
    navController: NavController,
    logInViewModel: LogInViewModel = hiltViewModel()){

    val isUserLogIn = logInViewModel.isUserLogIn.value

    LaunchedEffect(key1 = isUserLogIn){
        if(isUserLogIn){
            navController.navigate(NavigationItem.Profile.screen_route)
        }
    }

    val logInValidationState by logInViewModel.logInFormValidationState

    LogInFormComponent(
        signUpAndLogInInfoValidation = logInValidationState,
        onSignUpButtonClick = {
          navController.navigate(NavigationItem.SignUp.screen_route)
        },
        onLogInButtonClick = {
            logInViewModel.logIn(it)
        }
    )
}