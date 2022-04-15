package com.example.besonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.besonapp.presentation.FloatingComponentsGraph
import com.example.besonapp.presentation.screens.components.LoadingScreen
import com.example.besonapp.ui.theme.BesonAppTheme
import com.example.besonapp.ui.theme.SetSystemUiColorsAndPadding
import com.example.chatapp_by_command.view.BottomNavigationView
import com.google.accompanist.insets.*
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

//@AndroidEntryPoint
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

    //Notify floating components clicks
    var isSignUpScreenLogoClick by remember { mutableStateOf(false)}

    //Notify loading screen
    var isLoading by remember { mutableStateOf(false)}

    BesonAppTheme() {

        SetSystemUiColorsAndPadding(currentRoute){ applyPadding ->

            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        rememberInsetsPaddingValues(
                            insets = LocalWindowInsets.current.systemBars,
                            applyTop = applyPadding,
                            applyBottom = applyPadding,
                        )
                    )
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        keyboardController?.hide()
                    },

                scaffoldState = scaffoldState,

                bottomBar = {
                    BottomNavigationView(
                        navController = navController,
                        currentRoute = currentRoute)
                }

            ) {

                //Background Surface
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {

                    //Loading Screen
                    LoadingScreen(isLoading = isLoading) {

                        //Floating Components Logo, explaining strip etc.
                        FloatingComponentsGraph(
                            currentRoute = currentRoute,
                            onSignUpScreenLogoClick = {isSignUpScreenLogoClick = !isSignUpScreenLogoClick}
                        ){

                            //Navigation graph for navigate between screens.
                            NavigationGraph(
                                navController = navController,
                                isSignUpScreenLogoClick = isSignUpScreenLogoClick){ isLoadingFromScreen ->
                                isLoading = isLoadingFromScreen
                            }
                        }
                    }
                }
            }
        }
    }
}