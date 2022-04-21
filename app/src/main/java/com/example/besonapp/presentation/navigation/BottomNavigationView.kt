package com.example.chatapp_by_command.view

import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.besonapp.presentation.common_components.CustomBottomNavigationItem
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.ui.theme.NoRippleTheme


@Composable
fun BottomNavigationView(navController: NavController, currentRoute: String?) {
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
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.primary,
                elevation = 0.dp,
                modifier = Modifier
                    .padding(10.dp)
                    .clip(CircleShape)
            ) {

                items.forEach { item ->

                    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme){
                        CustomBottomNavigationItem(
                            icon = {
                                Icon(
                                    painter = rememberImagePainter(item.iconResource),
                                    contentDescription = item.title) },
                            label = {Text(text = item.title) },
                            alwaysShowLabel = false,
                            selectedContentColor = MaterialTheme.colors.onPrimary,
                            unselectedContentColor = MaterialTheme.colors.onPrimary,
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
        }
    )
}