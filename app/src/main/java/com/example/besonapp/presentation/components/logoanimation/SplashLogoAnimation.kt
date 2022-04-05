package com.example.besonapp.presentation

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.besonapp.NavigationItem
import com.example.besonapp.presentation.util.StaticTexts
import com.example.besonapp.ui.theme.logoBackground
import kotlinx.coroutines.delay

@Composable
fun SplashLogoAnimation(){

    val alphaAnim = remember { Animatable(0f) }
    LaunchedEffect(key1 = Unit){
        alphaAnim.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 2000,
                delayMillis = 1600
            )
        )
    }

    val rotateAnim = remember { Animatable(0f) }
    LaunchedEffect(key1 = Unit){
        rotateAnim.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 3600
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        CustomAppLogoIcon(alphaAnimValue = alphaAnim.value, rotateAnimValue = rotateAnim.value)

        Text(
            text = StaticTexts.APP_NAME,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .alpha(alpha = alphaAnim.value)
                .padding(top = 160.dp)
        )
    }
}