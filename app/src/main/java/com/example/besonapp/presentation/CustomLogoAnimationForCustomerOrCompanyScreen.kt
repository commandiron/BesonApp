package com.example.besonapp.presentation

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.besonapp.ui.theme.logoCircularBackGround

@Composable
fun CustomLogoAnimationForCustomerOrCompanyScreen(){
    var startAnimationSize by remember { mutableStateOf(false) }
    val sizeAnim = animateDpAsState(
        targetValue = if (startAnimationSize) 50.dp else 100.dp,
        animationSpec = tween(
            durationMillis = 2000
        )
    )
    LaunchedEffect(Unit) {
        startAnimationSize = true
    }

    val animatedFloat = remember { Animatable(0f) }
    LaunchedEffect(animatedFloat) {
        for(i in 0 until 10000){
            animatedFloat.animateTo(
                targetValue = 360f,
                animationSpec = repeatable(
                    iterations = 1,
                    animation = tween(800),
                    initialStartOffset = StartOffset(5000)
                )
            )
            animatedFloat.animateTo(
                targetValue = 0f,
                animationSpec = repeatable(
                    iterations = 1,
                    animation = tween(800)
                )
            )
            animatedFloat.animateTo(
                targetValue = -360f,
                animationSpec = repeatable(
                    iterations = 1,
                    animation = tween(800),
                    initialStartOffset = StartOffset(5000)
                )
            )
            animatedFloat.animateTo(
                targetValue = 0f,
                animationSpec = repeatable(
                    iterations = 1,
                    animation = tween(800)
                )
            )
        }
    }

    Box(
        modifier = Modifier
            .padding(bottom = 56.dp),
        contentAlignment = Alignment.Center){

        Surface(
            modifier = Modifier.clip(CircleShape),
            color = logoCircularBackGround
        ) {
            CustomAppLogoIcon(
                modifier = Modifier.padding(20.dp),
                tint = MaterialTheme.colors.onBackground,
                sizeAnimValue = sizeAnim.value,
                rotateAnimValue = animatedFloat.value
            )
        }
    }
}