package com.example.besonapp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.ui.theme.backgroundLight
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(Unit) {

        delay(5000)

        navController.popBackStack()
        navController.navigate(NavigationItem.Intro.screenRoute)
    }
    Box(
        contentAlignment = Alignment.Center) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = backgroundLight
        ) {

        }
    }
}
