package com.example.besonapp.presentation

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.ui.theme.logoColor
import com.example.besonapp.util.AnimationConstants.SPLASH_SCREEN_LOGO_ANIMATION_ALPHA_AGAIN_DELAY
import com.example.besonapp.util.AnimationConstants.SPLASH_SCREEN_LOGO_ANIMATION_ALPHA_AGAIN_DURATION
import com.example.besonapp.util.AnimationConstants.SPLASH_SCREEN_LOGO_ANIMATION_ALPHA_DELAY
import com.example.besonapp.util.AnimationConstants.SPLASH_SCREEN_LOGO_ANIMATION_ALPHA_DURATION
import com.example.besonapp.util.AnimationConstants.SPLASH_SCREEN_LOGO_ANIMATION_ROTATE_DELAY
import com.example.besonapp.util.AnimationConstants.SPLASH_SCREEN_LOGO_ANIMATION_ROTATE_DURATION
import com.example.besonapp.util.AppStaticTexts

@Composable
fun SplashScreenLogoAnimation(

){

    val alphaAnim = remember { Animatable(0f) }
    val rotateAnim = remember { Animatable(0f) }
    LaunchedEffect(key1 = Unit){
        alphaAnim.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                delayMillis = SPLASH_SCREEN_LOGO_ANIMATION_ALPHA_DELAY,
                durationMillis = SPLASH_SCREEN_LOGO_ANIMATION_ALPHA_DURATION
            )
        )
        rotateAnim.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                delayMillis = SPLASH_SCREEN_LOGO_ANIMATION_ROTATE_DELAY,
                durationMillis = SPLASH_SCREEN_LOGO_ANIMATION_ROTATE_DURATION,
            )
        )
        alphaAnim.animateTo(
            targetValue = 0f,
            animationSpec = tween(
                delayMillis = SPLASH_SCREEN_LOGO_ANIMATION_ALPHA_AGAIN_DELAY,
                durationMillis = SPLASH_SCREEN_LOGO_ANIMATION_ALPHA_AGAIN_DURATION
            )
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        AppLogoIconView(alphaAnimValue = alphaAnim.value, rotateAnimValue = rotateAnim.value)

        Text(
            text = AppStaticTexts.APP_NAME,
            color = logoColor,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .alpha(alpha = alphaAnim.value)
                .padding(top = 160.dp)
        )
    }
}