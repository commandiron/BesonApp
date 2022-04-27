package com.example.besonapp.ui

import androidx.compose.runtime.Composable
import com.example.besonapp.presentation.navigation.NavigationItem

@Composable
fun TutorialGraph(
    currentRoute: String?,
    content: @Composable () -> Unit
){
    content()

    when(currentRoute){
        NavigationItem.Profile.screen_route -> {
            NavigationTutorialProfileScreen(
                enabled = false
            )
        }
    }
}