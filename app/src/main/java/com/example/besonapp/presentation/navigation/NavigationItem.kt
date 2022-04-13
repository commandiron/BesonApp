package com.example.besonapp.presentation.navigation

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

sealed class NavigationItem(var title:String, var icon:Int, var screen_route_without_arguments:String, var arguments: String, var screen_route: String){

    object Splash: NavigationItem(
        SPLASH_SCREEN_TITLE,
        R.drawable.ic_launcher_foreground,
        SPLASH_SCREEN_ROUTE,
        SPLASH_SCREEN_ARGUMENT,
        SPLASH_SCREEN_ROUTE + SPLASH_SCREEN_ARGUMENT
    )

    object Intro: NavigationItem(
        INTRO_SCREEN_TITLE,
        R.drawable.ic_launcher_foreground,
        INTRO_SCREEN_ROUTE,
        INTRO_SCREEN_ARGUMENT,
        INTRO_SCREEN_ROUTE + INTRO_SCREEN_ARGUMENT
    )

    object SignUp: NavigationItem(
        SIGNUP_SCREEN_TITLE,
        R.drawable.ic_launcher_foreground,
        SIGNUP_SCREEN_ROUTE,
        SIGNUP_SCREEN_ARGUMENT,
        SIGNUP_SCREEN_ROUTE + SIGNUP_SCREEN_ARGUMENT
    )

    object LogIn: NavigationItem(
        LOGIN_SCREEN_TITLE,
        R.drawable.ic_launcher_foreground,
        LOGIN_SCREEN_ROUTE,
        LOGIN_SCREEN_ARGUMENT,
        LOGIN_SCREEN_ROUTE + LOGIN_SCREEN_ARGUMENT
    )

    object SignUpStepsAsCustomer: NavigationItem(
        SIGNUP_STEPS_AS_CUSTOMER_SCREEN_TITLE,
        R.drawable.ic_launcher_foreground,
        SIGNUP_STEPS_AS_CUSTOMER_SCREEN_ROUTE,
        SIGNUP_STEPS_AS_CUSTOMER_SCREEN_ARGUMENT,
        SIGNUP_STEPS_AS_CUSTOMER_SCREEN_ROUTE + SIGNUP_STEPS_AS_CUSTOMER_SCREEN_ARGUMENT
    )

    object SignUpStepsAsCompany: NavigationItem(
        SIGNUP_STEPS_AS_COMPANY_SCREEN_TITLE,
        R.drawable.ic_launcher_foreground,
        SIGNUP_STEPS_AS_COMPANY_SCREEN_ROUTE,
        SIGNUP_STEPS_AS_COMPANY_SCREEN_ARGUMENT,
        SIGNUP_STEPS_AS_COMPANY_SCREEN_ROUTE + SIGNUP_STEPS_AS_COMPANY_SCREEN_ARGUMENT
    )


    object Profile : NavigationItem(
        PROFILE_SCREEN_TITLE,
        R.drawable.ic_launcher_foreground,
        PROFILE_SCREEN_ROUTE,
        PROFILE_SCREEN_ARGUMENT,
        PROFILE_SCREEN_ROUTE + PROFILE_SCREEN_ARGUMENT
    )

    object Catagories : NavigationItem(
        CATAGORIES_SCREEN_TITLE,
        R.drawable.ic_launcher_foreground,
        CATAGORIES_SCREEN_ROUTE,
        CATAGORIES_SCREEN_ARGUMENT,
        CATAGORIES_SCREEN_ROUTE + CATAGORIES_SCREEN_ARGUMENT
    )

    object Settings : NavigationItem(
        SETTINGS_SCREEN_TITLE,
        R.drawable.ic_launcher_foreground,
        SETTINGS_SCREEN_ROUTE,
        SETTINGS_SCREEN_ARGUMENT,
        SETTINGS_SCREEN_ROUTE + SETTINGS_SCREEN_ARGUMENT
    )
}

