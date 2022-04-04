package com.example.besonapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import com.example.besonapp.NavigationItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SetSystemUiColors(
    currentRoute: String?,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable (Boolean) -> Unit){

    val systemUiController = rememberSystemUiController()

    var applySystemUiPadding by remember { mutableStateOf(true)}

    SideEffect{
        when(currentRoute){
            NavigationItem.Splash.screenRoute ->{

                //applySystemUiPadding = false

                systemUiController.setSystemBarsColor(
                    color = Color(0xff333333),
                    darkIcons = false)
            }

            NavigationItem.SelectCustomerOrCompany.screenRoute ->{

                //applySystemUiPadding = false

                systemUiController.setStatusBarColor(
                    color = Color(0xff333333),
                    darkIcons = false
                )

                systemUiController.setNavigationBarColor(
                    color = Color(0xff333333),
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