package com.example.besonapp.presentation.common_components.logoanimation

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.AppLogoIconView

@Composable
fun LogInScreenLogoAnimationOnStart(){

    val alphaAnim = remember { Animatable(1f) }
    LaunchedEffect(key1 = Unit){
        alphaAnim.animateTo(
            targetValue = 0f,
            animationSpec = tween(
                durationMillis = 500,
                easing = LinearEasing
            )
        )
    }

    val sizeAnim = remember { Animatable(50f) }
    LaunchedEffect(key1 = Unit){
        sizeAnim.animateTo(
            targetValue = 1000f,
            animationSpec = tween(
                durationMillis = 2000
            )
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

            AppLogoIconView(
                modifier = Modifier.padding(20.dp),
                sizeAnimValue = Dp(sizeAnim.value),
                alphaAnimValue = alphaAnim.value
            )
    }
}