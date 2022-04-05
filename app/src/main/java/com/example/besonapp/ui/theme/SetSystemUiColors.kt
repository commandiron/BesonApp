package com.example.besonapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import com.example.besonapp.NavigationItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SetSystemUiColors(
    currentRoute: String?,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable (Boolean) -> Unit){

    val systemUiController = rememberSystemUiController()

    val applySystemUiPadding by remember { mutableStateOf(true)}

    SideEffect{
        when(currentRoute){
            NavigationItem.Splash.screenRoute ->{

                //applySystemUiPadding = false

                systemUiController.setSystemBarsColor(
                    color = logoBackground,
                    darkIcons = false)
            }

            NavigationItem.Login.screenRoute ->{

                //applySystemUiPadding = false

                systemUiController.setStatusBarColor(
                    color = logoBackground,
                    darkIcons = false
                )

                systemUiController.setNavigationBarColor(
                    color = logoBackground,
                    darkIcons = false
                )
            }

            else -> {

//                applySystemUiPadding = false
//
//                if(darkTheme){
//                    systemUiController.setStatusBarColor(color = backgroundColorDark)
//                    systemUiController.setNavigationBarColor(primaryColorDark)
//                }else{
//                    systemUiController.setStatusBarColor(color = backgroundColorLight)
//                    systemUiController.setNavigationBarColor(primaryColorLight)
//                }
            }
        }
    }
    content(applySystemUiPadding)
}