package com.example.besonapp.presentation.floating_components.intro

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.AppLogoIconView
import com.example.besonapp.ui.theme.backgroundLight
import com.example.besonapp.util.StaticTexts

@Composable
fun IntroScreenLogoAnimation(){

    val sizeAnim = remember { Animatable(100f) }
    LaunchedEffect(key1 = Unit){
        sizeAnim.animateTo(
            targetValue = 50f,
            animationSpec = tween(
                durationMillis = 2000
            )
        )
    }


    val rotateAnim= remember { Animatable(0f) }
    LaunchedEffect(rotateAnim) {
        for(i in 0 until 10000){
            rotateAnim.animateTo(
                targetValue = 360f,
                animationSpec = repeatable(
                    iterations = 1,
                    animation = tween(800),
                    initialStartOffset = StartOffset(5000)
                )
            )
            rotateAnim.animateTo(
                targetValue = 0f,
                animationSpec = repeatable(
                    iterations = 1,
                    animation = tween(800)
                )
            )
            rotateAnim.animateTo(
                targetValue = -360f,
                animationSpec = repeatable(
                    iterations = 1,
                    animation = tween(800),
                    initialStartOffset = StartOffset(5000)
                )
            )
            rotateAnim.animateTo(
                targetValue = 0f,
                animationSpec = repeatable(
                    iterations = 1,
                    animation = tween(800)
                )
            )
        }
    }

    val paddingBottomAnim = remember { Animatable(0f) }
    LaunchedEffect(key1 = Unit){
        paddingBottomAnim.animateTo(
            targetValue = 660f,
            animationSpec = repeatable(
                iterations = 1,
                animation = tween(durationMillis = 1500, delayMillis = 2000)
            )
        )
    }
    val paddingEndAnim = remember { Animatable(0f) }
    LaunchedEffect(key1 = Unit){
        paddingEndAnim.animateTo(
            targetValue = 300f,
            animationSpec = repeatable(
                iterations = 1,
                animation = tween(durationMillis = 2000, delayMillis = 3500)
            )
        )
    }

    val textAlphaAnim = remember { Animatable(0f) }
    LaunchedEffect(key1 = Unit){
        textAlphaAnim.animateTo(
            targetValue = 1f,
            animationSpec = repeatable(
                iterations = 1,
                animation = tween(durationMillis = 1000, delayMillis = 5500)
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = Dp(paddingBottomAnim.value), end = Dp(paddingEndAnim.value)),
        contentAlignment = Alignment.Center
    ) {

        AppLogoIconView(
            modifier = Modifier.padding(20.dp),
            tint = MaterialTheme.colors.onBackground,
            sizeAnimValue = Dp(sizeAnim.value),
            rotateAnimValue = rotateAnim.value
        )
    }
    Text(
        text = StaticTexts.APP_NAME,
        color = MaterialTheme.colors.onBackground,
        style = MaterialTheme.typography.h2,
        modifier = Modifier.alpha(alpha = textAlphaAnim.value).padding(horizontal = 80.dp, vertical = 86.dp)
    )
}