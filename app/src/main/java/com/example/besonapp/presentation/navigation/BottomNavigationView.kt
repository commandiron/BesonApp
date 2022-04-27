package com.example.chatapp_by_command.view

import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.besonapp.presentation.common_components.CustomBottomNavigationItem
import com.example.besonapp.presentation.navigation.NavigationItem


@Composable
fun BottomNavigationView(
    navController: NavController,
    currentRoute: String?) {

    val items = listOf(
        NavigationItem.Profile,
        NavigationItem.Prices
    )

    val bottomBarMTS = remember {MutableTransitionState(false)}

    LaunchedEffect(key1 = currentRoute){

        val screenRouteList = items.map { it.screen_route }

        bottomBarMTS.targetState = screenRouteList.contains(currentRoute)
    }
    
    AnimatedVisibility(
        visibleState = bottomBarMTS,
        enter = fadeIn(tween(1000)),
        exit = fadeOut(tween(1000)),
        content = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.background,
                elevation = 0.dp
            ) {

                items.forEach { item ->

                    CustomBottomNavigationItem(
                        icon = {
                            Icon(
                                painter = rememberImagePainter(item.iconResource),
                                contentDescription = item.title) },
                        label = {
                            Text(
                                text = item.title,
                                color = MaterialTheme.colors.onBackground) },
                        alwaysShowLabel = false,
                        selectedContentColor = MaterialTheme.colors.onBackground,
                        unselectedContentColor = MaterialTheme.colors.onBackground.copy(0.5f),
                        selected = currentRoute == item.screen_route_without_arguments,
                        onClick = {
                            navController.navigate(item.screen_route_without_arguments) {
                                navController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    )
}