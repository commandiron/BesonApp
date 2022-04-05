package com.example.besonapp.presentation.components.logoanimation

import androidx.compose.animation.core.*
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.CustomAppLogoIcon
import com.example.besonapp.ui.theme.logoBackground

@Composable
fun LogInLogoAnimation(){

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

            CustomAppLogoIcon(
                modifier = Modifier.padding(20.dp),
                tint = MaterialTheme.colors.onBackground,
                sizeAnimValue = Dp(sizeAnim.value),
                alphaAnimValue = alphaAnim.value
            )

    }
}