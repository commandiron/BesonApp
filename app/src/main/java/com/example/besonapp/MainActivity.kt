package com.example.besonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.besonapp.presentation.FloatingComponentsGraph
import com.example.besonapp.presentation.common_components.CustomFloatingActionButton
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.presentation.screens.components.LoadingScreen
import com.example.besonapp.ui.TutorialGraph
import com.example.besonapp.presentation.theme.BesonAppTheme
import com.example.besonapp.ui.theme.SystemUiColorsAndPaddingGraph
import com.example.besonapp.presentation.theme.onPrimaryColorNoTheme
import com.example.besonapp.presentation.theme.primaryVariantColorNoTheme
import com.example.besonapp.presentation.top_bar.TopBarGraph
import com.example.chatapp_by_command.view.BottomNavigationView
import com.google.accompanist.insets.*
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //For Insets library
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            ProvideWindowInsets {
                MainContent()
            }
        }
    }
}


@Composable
fun MainContent(
    mainViewModel: MainViewModel = hiltViewModel()
){

    val scaffoldState = rememberScaffoldState()

    //KeyboardController for hide keyboard when touch outside
    val keyboardController = LocalSoftwareKeyboardController.current
    //For hide scaffold click ripple effect.
    val interactionSource = remember { MutableInteractionSource() }

    //Fab
    val fabState = rememberSaveable {(mutableStateOf(false))}
    var isFabClicked by remember { mutableStateOf(false)}

    //Navigation Control, Navigation Visibility
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberAnimatedNavController(bottomSheetNavigator)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    //Notify floating components clicks
    var isSignUpScreenLogoClick by remember { mutableStateOf(false)}

    //Notify loading screen
    var isLoading by remember { mutableStateOf(false)}

    //Notify tutorial graph
    var tutorialEnabled by remember { mutableStateOf(false)}

    //Main Theme
    BesonAppTheme {

        //Padding System Color and Padding
        SystemUiColorsAndPaddingGraph(currentRoute){ applyPaddingStatusBar, applyPaddingNavigationBar ->

            //Loading Screen
            LoadingScreen(isLoading = isLoading) {

                //Tutorial Screens
                TutorialGraph(
                    currentRoute = currentRoute,
                    enabled = tutorialEnabled,
                    profileScreenTutorialFinish = {
                        mainViewModel.setUserPassTutorialOnceFlagTrue()
                        tutorialEnabled = false
                    }
                ){

                    //Bottom Sheet (Over the scaffold because should above the navigation bar)
                    ModalBottomSheetLayout(
                        modifier = Modifier
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null
                            ) {
                                keyboardController?.hide()
                            },
                        bottomSheetNavigator = bottomSheetNavigator,
                        sheetShape = RoundedCornerShape(
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp,
                            topStart = 40.dp,
                            topEnd = 40.dp),
                        scrimColor = Color.Black.copy(0.5f)
                    ) {

                        //Layout For All App
                        Scaffold(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(
                                    rememberInsetsPaddingValues(
                                        insets = LocalWindowInsets.current.systemBars,
                                        applyTop = applyPaddingStatusBar,
                                        applyBottom = applyPaddingNavigationBar,
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
                                            currentRoute == NavigationItem.Prices.screen_route ||
                                                currentRoute == NavigationItem.PostPrice.screen_route

                                CustomFloatingActionButton(
                                    fabState = fabState.value,
                                    onClick = {
                                        isFabClicked = !isFabClicked

                                        navController.navigate(NavigationItem.PostPrice.screen_route)
                                    },
                                    backgroundColor = primaryVariantColorNoTheme) {

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
                                    currentRoute = currentRoute)
                            }

                        ) {

                            //I didn't need it.
                            it

                            //Surface for background to prevent unwanted glitches.
                            Surface(
                                modifier = Modifier
                                    .fillMaxSize(),
                                color = MaterialTheme.colors.background,
                            ){

                                //Floating Components Logo, explaining strip etc.
                                FloatingComponentsGraph(
                                    navController = navController,
                                    currentRoute = currentRoute,
                                    onSignUpScreenLogoClick = {isSignUpScreenLogoClick = !isSignUpScreenLogoClick}
                                ){

                                    //TopBar not in scaffold to prevent animation glitches.
                                    TopBarGraph(
                                        currentRoute = currentRoute
                                    ) {

                                        //Navigation graph for navigate between screens.
                                        NavigationGraph(
                                            navController = navController,
                                            isSignUpScreenLogoClick = isSignUpScreenLogoClick,
                                            isLoading = { isLoadingFromScreens ->
                                                isLoading = isLoadingFromScreens
                                            },
                                            runTutorial = {
                                                tutorialEnabled = true
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

