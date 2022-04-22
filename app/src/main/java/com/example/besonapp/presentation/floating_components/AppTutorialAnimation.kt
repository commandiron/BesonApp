package com.example.besonapp.presentation.floating_components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.common_components.CustomButton
import com.example.besonapp.ui.theme.onPrimaryColorNoTheme
import com.example.besonapp.util.AnimationConstants

@Composable
fun AppTutorialAnimation(){

    val textAlphaAnim = remember { Animatable(0f) }

    LaunchedEffect(key1 = Unit){
        textAlphaAnim.animateTo(
            targetValue = 1f,
            animationSpec = repeatable(
                iterations = 5,
                animation = tween(
                    delayMillis = AnimationConstants.PROFILE_SCREEN_TUTORIAL_ANIMATION_TEXT_ALPHA_DELAY,
                    durationMillis = AnimationConstants.PROFILE_SCREEN_TUTORIAL_ANIMATION_TEXT_ALPHA_DURATION
                )
            )
        )
        textAlphaAnim.animateTo(
            targetValue = 0f,
            animationSpec = repeatable(
                iterations = 1,
                animation = tween(
                    delayMillis = AnimationConstants.PROFILE_SCREEN_TUTORIAL_ANIMATION_TEXT_ALPHA_DELAY,
                    durationMillis = AnimationConstants.PROFILE_SCREEN_TUTORIAL_ANIMATION_TEXT_ALPHA_DURATION_CLOSE
                )
            )
        )
    }

    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .fillMaxSize().clickable(
                interactionSource = interactionSource,
                indication = null
            ){

             //Buraya tıkladıkça tutorial geçecek.
             println("click")

            } ,
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(top = 450.dp)
                .alpha(textAlphaAnim.value),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Fiyat Ekle")
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null)
        }
    }
}