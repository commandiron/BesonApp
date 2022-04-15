package com.example.besonapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.example.besonapp.presentation.navigation.NavigationItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SetSystemUiColorsAndPadding(
    currentRoute: String?,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable (Boolean) -> Unit){

    val systemUiController = rememberSystemUiController()

    var applySystemUiPadding by remember { mutableStateOf(true)}

    SideEffect{
        when(currentRoute){
            NavigationItem.Splash.screen_route ->{

                applySystemUiPadding = false

                systemUiController.setSystemBarsColor(
                    color = logoBackGround,
                    darkIcons = false
                )
            }

            NavigationItem.Intro.screen_route ->{

                applySystemUiPadding = false

                systemUiController.setStatusBarColor(
                    color = Color.Transparent,
                    darkIcons = !darkTheme
                )

                systemUiController.setNavigationBarColor(
                    color = Color.Transparent,
                    darkIcons = false
                )
            }

            NavigationItem.SignUp.screen_route ->{

                applySystemUiPadding = false

                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = !darkTheme
                )
            }

            NavigationItem.LogIn.screen_route ->{

                applySystemUiPadding = false

                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = !darkTheme
                )
            }

            NavigationItem.SignUpStepsAsCustomer.screen_route ->{

                applySystemUiPadding = false

                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = !darkTheme
                )
            }

            NavigationItem.Profile.screen_route ->{

                applySystemUiPadding = true

                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = false
                )
            }
        }
    }

    content(applySystemUiPadding)
}