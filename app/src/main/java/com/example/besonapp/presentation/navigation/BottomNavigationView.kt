package com.example.chatapp_by_command.view

import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.besonapp.presentation.navigation.NavigationItem


@Composable
fun BottomNavigationView(navController: NavController, currentRoute: String?) {
    val items = listOf(
        NavigationItem.Profile,
        NavigationItem.Catagories,
        NavigationItem.Settings
    )

    val bottomBarMTS = remember {MutableTransitionState(false)}

    LaunchedEffect(key1 = currentRoute){

        val screenRouteList = items.map { it.screen_route }

        bottomBarMTS.targetState = screenRouteList.contains(currentRoute)
    }
    
    AnimatedVisibility(
        visibleState = bottomBarMTS,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            androidx.compose.material.BottomNavigation(
                backgroundColor = MaterialTheme.colors.primary,
                modifier = Modifier
            ) {

                items.forEach { item ->

                    BottomNavigationItem(
                        icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                        label = { Text(text = item.title,
                            fontSize = 9.sp) },
                        alwaysShowLabel = false,
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