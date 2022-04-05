package com.example.besonapp

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@Composable
fun NavigationGraph(
    navController: NavHostController,
    isLogoClicked: Boolean
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
//                    BottomNavItem.SelectCustomerOrCompany.screenRoute -> slideOutOfContainer(AnimatedContentScope.SlideDirection.Up, animationSpec = tween(700))
                    else -> null
                }
            }) {

            SplashScreen(navController = navController)
        }

        //LOGIN SCREEN
        composable(
            NavigationItem.Login.screenRoute,
            enterTransition = {
                when(initialState.destination.route){
//                    BottomNavItem.Splash.screenRoute-> slideIntoContainer(AnimatedContentScope.SlideDirection.Up, animationSpec = tween(700))
                    else -> null
                }

            },
            exitTransition = {
                when(targetState.destination.route){
                    else -> null
                }
            }) {

            LogInScreen(navController, isLogoClicked)
        }
    }
}

