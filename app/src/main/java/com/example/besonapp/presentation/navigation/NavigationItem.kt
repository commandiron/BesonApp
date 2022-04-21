package com.example.besonapp.presentation.navigation

import android.content.Intent
import android.graphics.drawable.AdaptiveIconDrawable
import android.graphics.drawable.Drawable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import com.example.besonapp.R
import com.example.besonapp.presentation.navigation.NavigationConstants.INTRO_SCREEN_ARGUMENT
import com.example.besonapp.presentation.navigation.NavigationConstants.INTRO_SCREEN_ROUTE
import com.example.besonapp.presentation.navigation.NavigationConstants.INTRO_SCREEN_TITLE
import com.example.besonapp.presentation.navigation.NavigationConstants.LOGIN_SCREEN_ARGUMENT
import com.example.besonapp.presentation.navigation.NavigationConstants.LOGIN_SCREEN_ROUTE
import com.example.besonapp.presentation.navigation.NavigationConstants.LOGIN_SCREEN_TITLE
import com.example.besonapp.presentation.navigation.NavigationConstants.PRICES_SCREEN_ARGUMENT
import com.example.besonapp.presentation.navigation.NavigationConstants.PRICES_SCREEN_ROUTE
import com.example.besonapp.presentation.navigation.NavigationConstants.PRICES_SCREEN_TITLE
import com.example.besonapp.presentation.navigation.NavigationConstants.PROFILE_SCREEN_ARGUMENT
import com.example.besonapp.presentation.navigation.NavigationConstants.PROFILE_SCREEN_ROUTE
import com.example.besonapp.presentation.navigation.NavigationConstants.PROFILE_SCREEN_TITLE
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
import com.example.besonapp.presentation.navigation.NavigationConstants.UPDATE_PRICES_SCREEN_ARGUMENT
import com.example.besonapp.presentation.navigation.NavigationConstants.UPDATE_PRICES_SCREEN_ROUTE
import com.example.besonapp.presentation.navigation.NavigationConstants.UPDATE_PRICES_SCREEN_TITLE

sealed class NavigationItem(
    var title:String,
    var iconResource: Int? = null,
    var screen_route_without_arguments:String,
    var arguments: String,
    var screen_route: String){

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
        title = PROFILE_SCREEN_TITLE,
        iconResource = R.drawable.ic_profile_icon,
        screen_route_without_arguments = PROFILE_SCREEN_ROUTE,
        arguments = PROFILE_SCREEN_ARGUMENT,
        screen_route = PROFILE_SCREEN_ROUTE + PROFILE_SCREEN_ARGUMENT
    )

    object Prices : NavigationItem(
        title = PRICES_SCREEN_TITLE,
        iconResource = R.drawable.ic_prices_icon,
        screen_route_without_arguments = PRICES_SCREEN_ROUTE,
        arguments = PRICES_SCREEN_ARGUMENT,
        screen_route = PRICES_SCREEN_ROUTE + PRICES_SCREEN_ARGUMENT
    )

    object UpdatePrices : NavigationItem(
        title = UPDATE_PRICES_SCREEN_TITLE,
        screen_route_without_arguments = UPDATE_PRICES_SCREEN_ROUTE,
        arguments = UPDATE_PRICES_SCREEN_ARGUMENT,
        screen_route = UPDATE_PRICES_SCREEN_ROUTE + UPDATE_PRICES_SCREEN_ARGUMENT
    )
}

