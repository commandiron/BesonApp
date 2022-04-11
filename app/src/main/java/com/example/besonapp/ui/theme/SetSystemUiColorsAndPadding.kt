package com.example.besonapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
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
            NavigationItem.Splash.screenRoute ->{

                applySystemUiPadding = false

                systemUiController.setSystemBarsColor(
                    color = logoBackGround,
                    darkIcons = false
                )
            }

            NavigationItem.Intro.screenRoute ->{

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

            NavigationItem.SignUp.screenRoute ->{

                applySystemUiPadding = false

                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = !darkTheme
                )
            }

            NavigationItem.LogIn.screenRoute ->{

                applySystemUiPadding = true

                systemUiController.setSystemBarsColor(
                    color = logoBackGround,
                    darkIcons = false
                )
            }
        }
    }

    content(applySystemUiPadding)
}