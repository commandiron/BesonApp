package com.example.besonapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.ui.theme.logoBackGround
import com.example.besonapp.util.AnimationConstants.SPLASH_SCREEN_DELAY
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navController: NavController,
//    splashViewModel: SplashViewModel = hiltViewModel()
) {

//    val isUserOpenAppOnce = splashViewModel.isUserOpenAppOnce.value
//
//    LaunchedEffect(isUserOpenAppOnce) {
//
//        if(isUserOpenAppOnce){
//            navController.popBackStack()
//            navController.navigate(NavigationItem.SignUp.screenRoute)
//        }else{
//
//            delay(SPLASH_SCREEN_DELAY.toLong())
//
//            navController.popBackStack()
//            navController.navigate(NavigationItem.Intro.screenRoute)
//        }
//    }

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
