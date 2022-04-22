package com.example.besonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.besonapp.presentation.FloatingComponentsGraph
import com.example.besonapp.presentation.common_components.CustomFloatingActionButton
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.presentation.screens.components.LoadingScreen
import com.example.besonapp.ui.theme.BesonAppTheme
import com.example.besonapp.ui.theme.SetSystemUiColorsAndPadding
import com.example.besonapp.ui.theme.onPrimaryColorNoTheme
import com.example.besonapp.ui.theme.primaryVariantColorNoTheme
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

    //Fab
    val fabState = rememberSaveable {(mutableStateOf(false))}
    var isFabClicked by remember { mutableStateOf(false)}

    //Navigation Control and Navigation Visibility
    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    //Notify floating components clicks
    var isSignUpScreenLogoClick by remember { mutableStateOf(false)}

    //To reduce alpha of screen during the tutorial
    val screenAlphaForTutorial by remember { mutableStateOf(1.0f)}

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

                floatingActionButton = {

                    fabState.value =
                        currentRoute == NavigationItem.Profile.screen_route ||
                                currentRoute == NavigationItem.Prices.screen_route

                    CustomFloatingActionButton(
                        fabState = fabState.value,
                        onClick = {
                            isFabClicked = !isFabClicked

                            navController.navigate(NavigationItem.UpdatePrices.screen_route)
                        },
                        backgroundColor = primaryVariantColorNoTheme,
                        screenAlphaForTutorial = screenAlphaForTutorial) {

                        Icon(
                            imageVector = Icons.Filled.Add,
                            tint = onPrimaryColorNoTheme,
                            contentDescription = null,
                        )
                    }
                },
                isFloatingActionButtonDocked = true,
                floatingActionButtonPosition = FabPosition.Center,

                bottomBar = {

                    BottomNavigationView(
                        navController = navController,
                        currentRoute = currentRoute,
                        screenAlphaForTutorial = screenAlphaForTutorial)
                }

            ) {

                //I don't know what it is used for.
                println("unUsedPaddingValues: " + it)

                //Background Surface

                //BURDA KALDIM, DELİK OLUŞTURMAYA ÇALIŞIYORUM
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(screenAlphaForTutorial),
                    color = MaterialTheme.colors.background,
                ){

                    //Loading Screen
                    LoadingScreen(isLoading = isLoading) {

                        //Floating Components Logo, explaining strip etc.
                        FloatingComponentsGraph(
                            navController = navController,
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

