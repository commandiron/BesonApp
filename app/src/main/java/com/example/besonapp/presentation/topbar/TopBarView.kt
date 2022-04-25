package com.example.besonapp.presentation.topbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.ui.theme.onPrimaryColorNoTheme
import com.example.besonapp.ui.theme.primaryColorNoTheme

@Composable
fun TopBarView(
    currentRoute: String?) {

    val items = listOf(
        NavigationItem.Profile,
        NavigationItem.Prices
    )

    val topBarMTS = remember { MutableTransitionState(false) }

    LaunchedEffect(key1 = currentRoute){

        val screenRouteList = items.map { it.screen_route }

        topBarMTS.targetState = screenRouteList.contains(currentRoute)
    }

    AnimatedVisibility(
        visibleState = topBarMTS,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            TopAppBar(
                backgroundColor = primaryColorNoTheme,
                contentColor = onPrimaryColorNoTheme,
                elevation = 5.dp
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 10.dp),
                    contentAlignment = Alignment.Center
                ) {

                    for(i in items){
                        if(currentRoute == i.screen_route){
                            Text(
                                text = i.title,
                                style = MaterialTheme.typography.h3)
                        }
                    }
                }
            }
        }
    )
}