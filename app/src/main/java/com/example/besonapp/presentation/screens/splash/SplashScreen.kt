package com.example.besonapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.besonapp.presentation.ui.navigation.NavigationItem
import com.example.besonapp.presentation.screens.splash.SplashViewModel
import com.example.besonapp.presentation.ui.theme.logoBackGround
import com.example.besonapp.util.AnimationConstants.SPLASH_SCREEN_DELAY
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navController: NavController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {

    val isUserOpenAppOnce = splashViewModel.isUserOpenAppOnce.value

    LaunchedEffect(isUserOpenAppOnce) {

        if(isUserOpenAppOnce){
            navController.popBackStack()
            navController.navigate(NavigationItem.SignUp.screen_route)
        }else{

            delay(SPLASH_SCREEN_DELAY.toLong())

            navController.popBackStack()
            navController.navigate(NavigationItem.Intro.screen_route)
        }
    }

    LaunchedEffect(key1 = Unit){
        delay(SPLASH_SCREEN_DELAY.toLong())

        navController.popBackStack()
        navController.navigate(NavigationItem.Intro.screen_route)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = logoBackGround
    ) {

    }
}
