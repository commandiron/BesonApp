package com.example.besonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.besonapp.presentation.LogoAnimationGraph
import com.example.besonapp.ui.theme.BesonAppTheme
import com.example.besonapp.ui.theme.SetSystemUiColors
import com.example.chatapp_by_command.view.BottomNavigationView
import com.google.accompanist.insets.*
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //For Insets library
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {

            ProvideWindowInsets() {
                MainContent()
            }

        }
    }
}

@Composable
fun MainContent(){

    val scaffoldState = rememberScaffoldState()

    //KeyboardController for hide keyboard when touch outside
    val keyboardController = LocalSoftwareKeyboardController.current
    //For hide scaffold click ripple effect.
    val interactionSource = remember { MutableInteractionSource() }

    //Navigation Control and Navigation Visibility
    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    //LogoClicked
    var isLogoClicked by remember { mutableStateOf(false)}

    BesonAppTheme() {

        SetSystemUiColors(currentRoute){

            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        rememberInsetsPaddingValues(
                            insets = LocalWindowInsets.current.systemBars,
                            applyTop = it,
                            applyBottom = it
                        )
                    )
                    .clickable(interactionSource = interactionSource, indication = null){
                                keyboardController?.hide()
                    },

                scaffoldState = scaffoldState,

                bottomBar = {
                    BottomNavigationView(navController = navController, currentRoute = currentRoute)
                }

            ) {
                LogoAnimationGraph(currentRoute,{
                    isLogoClicked = !isLogoClicked
                }){

                    NavigationGraph(navController, isLogoClicked)
                }
            }
        }
    }
}