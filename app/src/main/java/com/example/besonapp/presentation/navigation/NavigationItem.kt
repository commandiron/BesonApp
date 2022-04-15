package com.example.besonapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.besonapp.R
import com.example.besonapp.presentation.navigation.NavigationConstants.CATAGORIES_SCREEN_ARGUMENT
import com.example.besonapp.presentation.navigation.NavigationConstants.CATAGORIES_SCREEN_ROUTE
import com.example.besonapp.presentation.navigation.NavigationConstants.CATAGORIES_SCREEN_TITLE
import com.example.besonapp.presentation.navigation.NavigationConstants.INTRO_SCREEN_ARGUMENT
import com.example.besonapp.presentation.navigation.NavigationConstants.INTRO_SCREEN_ROUTE
import com.example.besonapp.presentation.navigation.NavigationConstants.INTRO_SCREEN_TITLE
import com.example.besonapp.presentation.navigation.NavigationConstants.LOGIN_SCREEN_ARGUMENT
import com.example.besonapp.presentation.navigation.NavigationConstants.LOGIN_SCREEN_ROUTE
import com.example.besonapp.presentation.navigation.NavigationConstants.LOGIN_SCREEN_TITLE
import com.example.besonapp.presentation.navigation.NavigationConstants.PROFILE_SCREEN_ARGUMENT
import com.example.besonapp.presentation.navigation.NavigationConstants.PROFILE_SCREEN_ROUTE
import com.example.besonapp.presentation.navigation.NavigationConstants.PROFILE_SCREEN_TITLE
import com.example.besonapp.presentation.navigation.NavigationConstants.SETTINGS_SCREEN_ARGUMENT
import com.example.besonapp.presentation.navigation.NavigationConstants.SETTINGS_SCREEN_ROUTE
import com.example.besonapp.presentation.navigation.NavigationConstants.SETTINGS_SCREEN_TITLE
import com.example.besonapp.presentation.navigation.NavigationConstants.SIGNUP_SCREEN_ARGUMENT
import com.example.besonapp.presentation.navigation.NavigationConstants.SIGNUP_SCREEN_ROUTE
import com.example.besonapp.presentation.navigation.NavigationConstants.SIGNUP_SCREEN_TITLE
import com.example.besonapp.presentation.navigation.NavigationConstants.SIGNUP_STEPS_AS_COMPANY_SCREEN_ARGUMENT
import com.example.besonapp.presentation.navigation.NavigationConstants.SIGNUP_STEPS_AS_COMPANY_SCREEN_ROUTE
import com.example.besonapp.presentation.navigation.NavigationConstants.SIGNUP_STEPS_AS_COMPANY_SCREEN_TITLE
import com.example.besonapp.presentation.navigation.NavigationConstants.SIGNUP_STEPS_AS_CUSTOMER_SCREEN_ARGUMENT
import com.example.besonapp.presentation.navigation.NavigationConstants.SIGNUP_STEPS_AS_CUSTOMER_SCREEN_ROUTE
import com.example.besonapp.presentation.navigation.NavigationConstants.SIGNUP_STEPS_AS_CUSTOMER_SCREEN_TITLE
import com.example.besonapp.presentation.navigation.NavigationConstants.SPLASH_SCREEN_ARGUMENT
import com.example.besonapp.presentation.navigation.NavigationConstants.SPLASH_SCREEN_ROUTE
import com.example.besonapp.presentation.navigation.NavigationConstants.SPLASH_SCREEN_TITLE

sealed class NavigationItem(var title:String, var icon:ImageVector? = null, var screen_route_without_arguments:String, var arguments: String, var screen_route: String){

    object Splash: NavigationItem(
        title = SPLASH_SCREEN_TITLE,
        screen_route_without_arguments = SPLASH_SCREEN_ROUTE,
        arguments = SPLASH_SCREEN_ARGUMENT,
        screen_route = SPLASH_SCREEN_ROUTE + SPLASH_SCREEN_ARGUMENT
    )

    object Intro: NavigationItem(
        title = INTRO_SCREEN_TITLE,
        screen_route_without_arguments = INTRO_SCREEN_ROUTE,
        arguments = INTRO_SCREEN_ARGUMENT,
        screen_route = INTRO_SCREEN_ROUTE + INTRO_SCREEN_ARGUMENT
    )

    object SignUp: NavigationItem(
        title = SIGNUP_SCREEN_TITLE,
        screen_route_without_arguments = SIGNUP_SCREEN_ROUTE,
        arguments = SIGNUP_SCREEN_ARGUMENT,
        screen_route = SIGNUP_SCREEN_ROUTE + SIGNUP_SCREEN_ARGUMENT
    )

    object LogIn: NavigationItem(
        title = LOGIN_SCREEN_TITLE,
        screen_route_without_arguments = LOGIN_SCREEN_ROUTE,
        arguments = LOGIN_SCREEN_ARGUMENT,
        screen_route = LOGIN_SCREEN_ROUTE + LOGIN_SCREEN_ARGUMENT
    )

    object SignUpStepsAsCustomer: NavigationItem(
        title = SIGNUP_STEPS_AS_CUSTOMER_SCREEN_TITLE,
        screen_route_without_arguments = SIGNUP_STEPS_AS_CUSTOMER_SCREEN_ROUTE,
        arguments = SIGNUP_STEPS_AS_CUSTOMER_SCREEN_ARGUMENT,
        screen_route = SIGNUP_STEPS_AS_CUSTOMER_SCREEN_ROUTE + SIGNUP_STEPS_AS_CUSTOMER_SCREEN_ARGUMENT
    )

    object SignUpStepsAsCompany: NavigationItem(
        title = SIGNUP_STEPS_AS_COMPANY_SCREEN_TITLE,
        screen_route_without_arguments = SIGNUP_STEPS_AS_COMPANY_SCREEN_ROUTE,
        arguments = SIGNUP_STEPS_AS_COMPANY_SCREEN_ARGUMENT,
        screen_route = SIGNUP_STEPS_AS_COMPANY_SCREEN_ROUTE + SIGNUP_STEPS_AS_COMPANY_SCREEN_ARGUMENT
    )


    object Profile : NavigationItem(
        PROFILE_SCREEN_TITLE,
        Icons.Default.Home,
        PROFILE_SCREEN_ROUTE,
        PROFILE_SCREEN_ARGUMENT,
        PROFILE_SCREEN_ROUTE + PROFILE_SCREEN_ARGUMENT
    )

    object Catagories : NavigationItem(
        CATAGORIES_SCREEN_TITLE,
        Icons.Default.Home,
        CATAGORIES_SCREEN_ROUTE,
        CATAGORIES_SCREEN_ARGUMENT,
        CATAGORIES_SCREEN_ROUTE + CATAGORIES_SCREEN_ARGUMENT
    )

    object Settings : NavigationItem(
        SETTINGS_SCREEN_TITLE,
        Icons.Default.Home,
        SETTINGS_SCREEN_ROUTE,
        SETTINGS_SCREEN_ARGUMENT,
        SETTINGS_SCREEN_ROUTE + SETTINGS_SCREEN_ARGUMENT
    )
}

