package com.example.besonapp.presentation.floating_components.intro

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.AppLogoIconView
import com.example.besonapp.util.AnimationConstants.INTRO_SCREEN_LOGO_ANIMATION_PADDING_BOTTOM_DELAY
import com.example.besonapp.util.AnimationConstants.INTRO_SCREEN_LOGO_ANIMATION_PADDING_BOTTOM_DURATION
import com.example.besonapp.util.AnimationConstants.INTRO_SCREEN_LOGO_ANIMATION_PADDING_END_DELAY
import com.example.besonapp.util.AnimationConstants.INTRO_SCREEN_LOGO_ANIMATION_PADDING_END_DURATION
import com.example.besonapp.util.AnimationConstants.INTRO_SCREEN_LOGO_ANIMATION_ROTATE_DELAY
import com.example.besonapp.util.AnimationConstants.INTRO_SCREEN_LOGO_ANIMATION_ROTATE_DURATION
import com.example.besonapp.util.AnimationConstants.INTRO_SCREEN_LOGO_ANIMATION_SIZE_DELAY
import com.example.besonapp.util.AnimationConstants.INTRO_SCREEN_LOGO_ANIMATION_SIZE_DURATION
import com.example.besonapp.util.AnimationConstants.INTRO_SCREEN_LOGO_ANIMATION_TEXT_ALPHA_DELAY
import com.example.besonapp.util.AnimationConstants.INTRO_SCREEN_LOGO_ANIMATION_TEXT_ALPHA_DURATION
import com.example.besonapp.util.AppStaticTexts

@Composable
fun IntroScreenLogoAnimation(){

    val rotateAnim= remember { Animatable(0f) }
    LaunchedEffect(rotateAnim) {
        for(i in 0 until 10000){
            rotateAnim.animateTo(
                targetValue = 360f,
                animationSpec = repeatable(
                    iterations = 1,
                    animation = tween(
                        delayMillis = INTRO_SCREEN_LOGO_ANIMATION_ROTATE_DELAY,
                        durationMillis = INTRO_SCREEN_LOGO_ANIMATION_ROTATE_DURATION),
                    initialStartOffset = StartOffset(5000)
                )
            )
            rotateAnim.animateTo(
                targetValue = 0f,
                animationSpec = repeatable(
                    iterations = 1,
                    animation = tween(
                        delayMillis = INTRO_SCREEN_LOGO_ANIMATION_ROTATE_DELAY,
                        durationMillis = INTRO_SCREEN_LOGO_ANIMATION_ROTATE_DURATION)
                )
            )
            rotateAnim.animateTo(
                targetValue = -360f,
                animationSpec = repeatable(
                    iterations = 1,
                    animation = tween(
                        delayMillis = INTRO_SCREEN_LOGO_ANIMATION_ROTATE_DELAY,
                        durationMillis = INTRO_SCREEN_LOGO_ANIMATION_ROTATE_DURATION),
                    initialStartOffset = StartOffset(5000)
                )
            )
            rotateAnim.animateTo(
                targetValue = 0f,
                animationSpec = repeatable(
                    iterations = 1,
                    animation = tween(
                        delayMillis = INTRO_SCREEN_LOGO_ANIMATION_ROTATE_DELAY,
                        durationMillis = INTRO_SCREEN_LOGO_ANIMATION_ROTATE_DURATION)
                )
            )
        }
    }

    val sizeAnim = remember { Animatable(100f) }
    val paddingBottomAnim = remember { Animatable(0f) }
    val paddingEndAnim = remember { Animatable(0f) }
    val textAlphaAnim = remember { Animatable(0f) }
    LaunchedEffect(key1 = Unit){
        sizeAnim.animateTo(
            targetValue = 50f,
            animationSpec = tween(
                delayMillis = INTRO_SCREEN_LOGO_ANIMATION_SIZE_DELAY,
                durationMillis = INTRO_SCREEN_LOGO_ANIMATION_SIZE_DURATION
            )
        )
        paddingBottomAnim.animateTo(
            targetValue = 660f,
            animationSpec = repeatable(
                iterations = 1,
                animation = tween(
                    delayMillis = INTRO_SCREEN_LOGO_ANIMATION_PADDING_BOTTOM_DELAY,
                    durationMillis = INTRO_SCREEN_LOGO_ANIMATION_PADDING_BOTTOM_DURATION)
            )
        )
        paddingEndAnim.animateTo(
            targetValue = 300f,
            animationSpec = repeatable(
                iterations = 1,
                animation = tween(
                    delayMillis = INTRO_SCREEN_LOGO_ANIMATION_PADDING_END_DELAY,
                    durationMillis = INTRO_SCREEN_LOGO_ANIMATION_PADDING_END_DURATION)
            )
        )
        textAlphaAnim.animateTo(
            targetValue = 1f,
            animationSpec = repeatable(
                iterations = 1,
                animation = tween(
                    delayMillis = INTRO_SCREEN_LOGO_ANIMATION_TEXT_ALPHA_DELAY,
                    durationMillis = INTRO_SCREEN_LOGO_ANIMATION_TEXT_ALPHA_DURATION)
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
        text = AppStaticTexts.APP_NAME,
        color = MaterialTheme.colors.onBackground,
        style = MaterialTheme.typography.h2,
        modifier = Modifier.alpha(alpha = textAlphaAnim.value).padding(horizontal = 80.dp, vertical = 86.dp)
    )
}