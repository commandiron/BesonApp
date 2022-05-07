package com.example.besonapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.example.besonapp.presentation.ui.navigation.NavigationItem
import com.example.besonapp.presentation.ui.theme.logoBackGround
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SystemUiColorsAndPaddingGraph(
    currentRoute: String?,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable (Boolean, Boolean) -> Unit){

    val systemUiController = rememberSystemUiController()

    var applyStatusBarPadding by remember { mutableStateOf(false)}
    var applyNavigationBarPadding by remember { mutableStateOf(false)}

    SideEffect{
        when(currentRoute){
            NavigationItem.Splash.screen_route ->{

                applyStatusBarPadding = false
                applyNavigationBarPadding = false

                systemUiController.setSystemBarsColor(
                    color = logoBackGround,
                    darkIcons = false
                )
            }

            NavigationItem.Intro.screen_route ->{

                applyStatusBarPadding = false
                applyNavigationBarPadding = false

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

                applyStatusBarPadding = false
                applyNavigationBarPadding = false

                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = !darkTheme
                )
            }

            NavigationItem.LogIn.screen_route ->{

                applyStatusBarPadding = false
                applyNavigationBarPadding = false

                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = !darkTheme
                )
            }

            NavigationItem.SignUpStepsAsCustomer.screen_route ->{

                applyStatusBarPadding = false
                applyNavigationBarPadding = false

                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = !darkTheme
                )
            }

            NavigationItem.Profile.screen_route ->{

                applyStatusBarPadding = false
                applyNavigationBarPadding = true

                systemUiController.setStatusBarColor(
                    color = Color.Transparent,
                    darkIcons = true
                )

                systemUiController.setNavigationBarColor(
                    color = Color.Transparent,
                    darkIcons = false
                )
            }

            NavigationItem.Prices.screen_route ->{

                applyStatusBarPadding = false
                applyNavigationBarPadding = true

                systemUiController.setStatusBarColor(
                    color = Color.Transparent,
                    darkIcons = true
                )

                systemUiController.setNavigationBarColor(
                    color = Color.Transparent,
                    darkIcons = false
                )
            }

            NavigationItem.PostPrice.screen_route ->{

                applyStatusBarPadding = false
                applyNavigationBarPadding = true

                systemUiController.setStatusBarColor(
                    color = Color.Transparent,
                    darkIcons = true
                )

                systemUiController.setNavigationBarColor(
                    color = Color.Transparent,
                    darkIcons = false
                )
            }
        }
    }

    content(applyStatusBarPadding, applyNavigationBarPadding)
}