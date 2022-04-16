package com.example.besonapp.presentation.floating_components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.AppLogoIconView
import com.example.besonapp.ui.theme.logoColor
import com.example.besonapp.util.AppStaticTexts

@Composable
fun SplashScreenLogoAnimation2(

){
    val logoRotateAnim = remember { Animatable(0f) }
    val logoBottomPaddingAnim = remember { Animatable(0f) }
    val textAlphaAnim = remember { Animatable(0f) }
    val textPaddingAnim = remember { Animatable(280f) }
    val textRotationXAnim = remember { Animatable(-30f) }

    LaunchedEffect(key1 = Unit){
        logoRotateAnim.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                delayMillis = 1000,
                durationMillis = 1000,
            )
        )
        logoBottomPaddingAnim.animateTo(
            targetValue = 80f,
            animationSpec = tween(
                delayMillis = 500,
                durationMillis = 1200,
            )
        )
    }


    LaunchedEffect(key1 = Unit){
        textAlphaAnim.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                delayMillis = 2500,
                durationMillis = 2000
            )
        )
    }

    LaunchedEffect(key1 = Unit){
        textPaddingAnim.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                delayMillis = 2500,
                durationMillis = 1000,
            )
        )
    }
    LaunchedEffect(key1 = Unit){
        textRotationXAnim.animateTo(
            targetValue = 0f,
            animationSpec = tween(
                delayMillis = 2500,
                durationMillis = 1000,
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        AppLogoIconView(
            rotateAnimValue = logoRotateAnim.value,
            paddingBottomAnimValue = logoBottomPaddingAnim.value)
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Text(
            text = AppStaticTexts.APP_NAME,
            color = logoColor,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .alpha(alpha = textAlphaAnim.value)
                .padding(bottom = Dp(textPaddingAnim.value))
                .graphicsLayer { rotationX = textRotationXAnim.value }

        )
    }
}