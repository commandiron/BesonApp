package com.example.besonapp.ui

import androidx.compose.runtime.Composable
import com.example.besonapp.presentation.ui.navigation.NavigationItem

@Composable
fun TutorialGraph(
    currentRoute: String?,
    enabled: Boolean,
    profileScreenTutorialFinish:() -> Unit,
    content: @Composable () -> Unit
){
    content()

    if(enabled){
        when(currentRoute){
            NavigationItem.Profile.screen_route -> {
                NavigationTutorialProfileScreen(
                    enabled = enabled,
                    profileScreenTutorialFinish = {profileScreenTutorialFinish()}
                )
            }
        }
    }
}