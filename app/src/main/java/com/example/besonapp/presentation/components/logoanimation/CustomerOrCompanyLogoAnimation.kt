package com.example.besonapp.presentation

import androidx.compose.animation.core.*
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.besonapp.ui.theme.logoBackground

@Composable
fun CustomerOrCompanyLogoAnimation(
    onLogoClick:() -> Unit
){

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

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val interactionSource = remember { MutableInteractionSource() }
        Surface(
            modifier = Modifier.clip(CircleShape).clickable(interactionSource, null) {
                onLogoClick()
            },
            color = logoBackground
        ) {
            CustomAppLogoIcon(
                modifier = Modifier.padding(20.dp),
                tint = MaterialTheme.colors.onBackground,
                sizeAnimValue = Dp(sizeAnim.value),
                rotateAnimValue = rotateAnim.value
            )
        }
    }
}