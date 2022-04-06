package com.example.besonapp.presentation.navigation

import com.example.besonapp.R
import com.example.besonapp.util.Constants.CATAGORIES_SCREEN_ROUTE
import com.example.besonapp.util.Constants.CATAGORIES_SCREEN_TITLE
import com.example.besonapp.util.Constants.INTRO_SCREEN_ROUTE
import com.example.besonapp.util.Constants.INTRO_SCREEN_TITLE
import com.example.besonapp.util.Constants.LOGIN_SCREEN_ROUTE
import com.example.besonapp.util.Constants.LOGIN_SCREEN_TITLE
import com.example.besonapp.util.Constants.PROFILE_SCREEN_ROUTE
import com.example.besonapp.util.Constants.PROFILE_SCREEN_TITLE
import com.example.besonapp.util.Constants.SETTINGS_SCREEN_ROUTE
import com.example.besonapp.util.Constants.SETTINGS_SCREEN_TITLE
import com.example.besonapp.util.Constants.SIGNUP_SCREEN_ROUTE
import com.example.besonapp.util.Constants.SIGNUP_SCREEN_TITLE
import com.example.besonapp.util.Constants.SPLASH_SCREEN_ROUTE
import com.example.besonapp.util.Constants.SPLASH_SCREEN_TITLE

sealed class NavigationItem(var title:String, var icon:Int, var screen_routeWithoutArguments:String, var arguments: String = ""){

    object Splash: NavigationItem(
        SPLASH_SCREEN_TITLE,
        R.drawable.ic_launcher_foreground,
        SPLASH_SCREEN_ROUTE,
    ){
        val screenRoute = screen_routeWithoutArguments + arguments
    }

    object Intro: NavigationItem(
        INTRO_SCREEN_TITLE,
        R.drawable.ic_launcher_foreground,
        INTRO_SCREEN_ROUTE,
    ){
        val screenRoute = screen_routeWithoutArguments + arguments
    }

    object SignUp: NavigationItem(
        SIGNUP_SCREEN_TITLE,
        R.drawable.ic_launcher_foreground,
        SIGNUP_SCREEN_ROUTE
    ){
        val screenRoute = screen_routeWithoutArguments + arguments
    }

    object LogIn: NavigationItem(
        LOGIN_SCREEN_TITLE,
        R.drawable.ic_launcher_foreground,
        LOGIN_SCREEN_ROUTE
    ){
        val screenRoute = screen_routeWithoutArguments + arguments
    }


    object Profile : NavigationItem(
        PROFILE_SCREEN_TITLE,
        R.drawable.ic_launcher_foreground,
        PROFILE_SCREEN_ROUTE
    ){
        val screenRoute = screen_routeWithoutArguments + arguments
    }

    object Catagories : NavigationItem(
        CATAGORIES_SCREEN_TITLE,
        R.drawable.ic_launcher_foreground,
        CATAGORIES_SCREEN_ROUTE
    ){
        val screenRoute = screen_routeWithoutArguments + arguments
    }

    object Settings : NavigationItem(
        SETTINGS_SCREEN_TITLE,
        R.drawable.ic_launcher_foreground,
        SETTINGS_SCREEN_ROUTE
    ){
        val screenRoute = screen_routeWithoutArguments + arguments
    }
}

