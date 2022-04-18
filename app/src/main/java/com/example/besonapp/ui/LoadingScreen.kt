package com.example.besonapp.presentation.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.floating_components.signup_steps.FloatingLogoWithAppName

@Composable
fun LoadingScreen(
    isLoading: Boolean = false,
    content: @Composable () -> Unit
){
    if(isLoading){
        Box(
            modifier = Modifier.background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {

            FloatingLogoWithAppName()

            CircularProgressIndicator(
                modifier = Modifier.size(30.dp),
                color = androidx.compose.material.MaterialTheme.colors.primary,
                strokeWidth = 3.dp
            )
        }
    }else{
        content()
    }
}