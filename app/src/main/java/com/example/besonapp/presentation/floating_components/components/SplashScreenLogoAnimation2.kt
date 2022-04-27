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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.AppLogoIconView
import com.example.besonapp.presentation.theme.logoColor
import com.example.besonapp.util.AppStaticTexts
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import kotlinx.coroutines.launch

@Composable
fun SplashScreenLogoAnimation2(){

    val scope = rememberCoroutineScope()

    val logoRotateAnim = remember { Animatable(0f) }
    val logoBottomPaddingAnim = remember { Animatable(0f) }
    val textAlphaAnim = remember { Animatable(0f) }
    val textPaddingAnim = remember { Animatable(200f) }
    val textRotationXAnim = remember { Animatable(-30f) }

    val introTextAlphaAnim = remember { Animatable(0f) }

    LaunchedEffect(key1 = Unit){

        scope.launch {
            logoRotateAnim.animateTo(
                targetValue = 360f,
                animationSpec = tween(
                    delayMillis = 1500,
                    durationMillis = 1000,
                )
            )
            logoBottomPaddingAnim.animateTo(
                targetValue = 40f,
                animationSpec = tween(
                    delayMillis = 0,
                    durationMillis = 1000,
                )
            )
        }
        scope.launch {
            textAlphaAnim.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    delayMillis = 2800,
                    durationMillis = 500
                )
            )
        }
        scope.launch {
            textPaddingAnim.animateTo(
                targetValue = 100f,
                animationSpec = tween(
                    delayMillis = 2800,
                    durationMillis = 500,
                )
            )
        }
        scope.launch {
            textRotationXAnim.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    delayMillis = 2800,
                    durationMillis = 500,
                )
            )
        }
        scope.launch {
            introTextAlphaAnim.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    delayMillis = 2800,
                    durationMillis = 100
                )
            )
        }
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
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = AppStaticTexts.APP_NAME,
            color = logoColor,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .alpha(alpha = textAlphaAnim.value)
                .padding(top =  Dp(textPaddingAnim.value))
                .graphicsLayer { rotationX = textRotationXAnim.value }

        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp),
        contentAlignment = Alignment.BottomCenter
    ) {

        Text(
            text = AppStaticTexts.APP_STATEMENT,
            color = logoColor,
            style = MaterialTheme.typography.body2,
            modifier = Modifier
                .alpha(alpha = introTextAlphaAnim.value)
        )
    }


}