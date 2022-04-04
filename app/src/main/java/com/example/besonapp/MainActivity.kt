package com.example.besonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.besonapp.ui.theme.BesonAppTheme
import com.example.besonapp.ui.theme.SetSystemUiColors
import com.example.chatapp_by_command.view.BottomNavigationView
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
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

    //Navigation Control and Navigation Visibility
    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

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
                    ),

                scaffoldState = scaffoldState,

                bottomBar = {
                    BottomNavigationView(navController = navController, currentRoute = currentRoute)
                },

                ){

                NavigationGraph(navController)
            }
        }
    }
}