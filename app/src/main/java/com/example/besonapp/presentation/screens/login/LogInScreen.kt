package com.example.besonapp.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.besonapp.presentation.screens.login.components.LogInFormComponent

@Composable
fun LogInScreen(navController: NavController){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        LogInFormComponent(
            onSignUpButtonClick = {
              navController.popBackStack()
            },
            onLogInButtonClick = {
                //Login ol
            }
        )
    }
}