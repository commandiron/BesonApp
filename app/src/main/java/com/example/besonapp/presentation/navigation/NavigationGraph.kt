package com.example.besonapp

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.presentation.screens.LogInScreen
import com.example.besonapp.presentation.screens.intro.IntroScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@Composable
fun NavigationGraph(
    navController: NavHostController,
    isSignUpScreenLogoClick: Boolean
) {

    AnimatedNavHost(navController, startDestination = NavigationItem.Splash.screenRoute) {

        //SPLASH SCREEN
        composable(
            NavigationItem.Splash.screenRoute,
            enterTransition = {
                when(initialState.destination.route){
                    else -> null
                }

            }, exitTransition = {

                when (targetState.destination.route) {
                    NavigationItem.Intro.screenRoute -> fadeOut(animationSpec = tween(2000))
                    else -> null
                }
            }) {

            SplashScreen(navController = navController)
        }

        //INTRO SCREEN
        composable(
            NavigationItem.Intro.screenRoute,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItem.Splash.screenRoute-> fadeIn(animationSpec = tween(2000))
                    else -> null
                }

            }, exitTransition = {
                when (targetState.destination.route) {
                    NavigationItem.SignUp.screenRoute -> scaleOut(animationSpec = tween(2000))
                    else -> null
                }
            }) {

            IntroScreen(navController = navController)
        }

        //SIGNUP SCREEN
        composable(
            NavigationItem.SignUp.screenRoute,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItem.Intro.screenRoute-> scaleIn(animationSpec = tween(2000))
                    else -> null
                }

            },
            exitTransition = {
                when(targetState.destination.route){
//                    NavigationItem.LogIn.screenRoute-> fadeOut(animationSpec = tween(1000))
                    else -> null
                }
            }) {

            SignUpScreen(navController, isSignUpScreenLogoClick)
        }

        //LOGIN SCREEN
        composable(
            NavigationItem.LogIn.screenRoute,
            enterTransition = {
                when(initialState.destination.route){
//                    NavigationItem.SignUp.screenRoute-> fadeIn(animationSpec = tween(1000))
                    else -> null
                }

            },
            exitTransition = {
                when(targetState.destination.route){
                    else -> null
                }
            }) {

            LogInScreen(navController)
        }
    }
}

