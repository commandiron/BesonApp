package com.example.besonapp

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.presentation.screens.LogInScreen
import com.example.besonapp.presentation.screens.ProfileScreen
import com.example.besonapp.presentation.screens.intro.IntroScreen
import com.example.besonapp.presentation.screens.signup_steps_as_customer.SignUpStepsAsCustomerScreen
import com.example.besonapp.util.AnimationConstants.INTRO_SCREEN_ENTER_TRANSITION_ANIMATION_DURATION
import com.example.besonapp.util.AnimationConstants.INTRO_SCREEN_EXIT_TRANSITION_ANIMATION_DURATION
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@Composable
fun NavigationGraph(
    navController: NavHostController,
    isSignUpScreenLogoClick: Boolean,
) {

    AnimatedNavHost(navController, startDestination = NavigationItem.Splash.screen_route) {

        //SPLASH SCREEN
        composable(
            NavigationItem.Splash.screen_route,
            enterTransition = {
                when(initialState.destination.route){
                    else -> null
                }

            }, exitTransition = {

                when (targetState.destination.route) {
                    else -> null
                }
            }) {

            SplashScreen(navController = navController)
        }

        //INTRO SCREEN
        composable(
            NavigationItem.Intro.screen_route,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItem.Splash.screen_route -> fadeIn(animationSpec = tween(INTRO_SCREEN_ENTER_TRANSITION_ANIMATION_DURATION))
                    else -> null
                }

            }, exitTransition = {
                when (targetState.destination.route) {
                    NavigationItem.SignUp.screen_route -> fadeOut(animationSpec = tween(INTRO_SCREEN_EXIT_TRANSITION_ANIMATION_DURATION))
                    else -> null
                }
            }) {

            IntroScreen(navController = navController)
        }

        //SIGNUP SCREEN
        composable(
            NavigationItem.SignUp.screen_route,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItem.Intro.screen_route-> scaleIn(animationSpec = tween(2000))
                    else -> null
                }

            },
            exitTransition = {
                when(targetState.destination.route){
                    NavigationItem.LogIn.screen_route-> fadeOut(animationSpec = tween(1000))
                    NavigationItem.SignUpStepsAsCustomer.screen_route-> fadeOut(animationSpec = tween(1000))
                    else -> null
                }
            }) {

            SignUpScreen(navController = navController, isSignUpScreenLogoClick = isSignUpScreenLogoClick)
        }

        //LOGIN SCREEN
        composable(
            NavigationItem.LogIn.screen_route,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItem.SignUp.screen_route-> fadeIn(animationSpec = tween(1000))
                    NavigationItem.SignUpStepsAsCustomer.screen_route-> fadeIn(animationSpec = tween(1000))
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

        //SIGNUP STEPS AS CUSTOMER SCREEN
        composable(
            NavigationItem.SignUpStepsAsCustomer.screen_route,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItem.SignUp.screen_route-> fadeIn(animationSpec = tween(1000))
                    else -> null
                }

            },
            exitTransition = {
                when(targetState.destination.route){
                    NavigationItem.LogIn.screen_route-> fadeOut(animationSpec = tween(1000))
                    else -> null
                }
            }) {

            SignUpStepsAsCustomerScreen(navController)
        }

        //PROFILE SCREEN
        composable(
            NavigationItem.Profile.screen_route,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItem.SignUpStepsAsCustomer.screen_route-> fadeIn(animationSpec = tween(1000))
                    else -> null
                }

            },
            exitTransition = {
                when(targetState.destination.route){
                    else -> null
                }
            }) {

            ProfileScreen(navController)
        }
    }
}

