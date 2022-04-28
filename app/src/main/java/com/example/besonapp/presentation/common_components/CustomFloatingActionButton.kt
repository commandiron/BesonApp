package com.example.besonapp.presentation.common_components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.theme.NoRippleTheme
import com.example.besonapp.presentation.theme.onPrimaryColorNoTheme
import com.example.besonapp.presentation.theme.primaryColorNoTheme

@Composable
fun CustomFloatingActionButton(
    fabState: Boolean,
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),
    backgroundColor: Color = primaryColorNoTheme,
    contentColor: Color = onPrimaryColorNoTheme,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    content: @Composable () -> Unit
) {
    rememberRipple()
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme){

        AnimatedVisibility(
            visible = fabState,
            enter = scaleIn(tween(durationMillis = 250)),
            exit = scaleOut(tween(durationMillis = 250))) {

            Surface(
                onClick = onClick,
                shape = shape,
                color = backgroundColor,
                contentColor = contentColor,
                elevation = elevation.elevation(interactionSource).value,
                interactionSource = interactionSource
            ) {

                CompositionLocalProvider(LocalContentAlpha provides contentColor.alpha) {

                    ProvideTextStyle(MaterialTheme.typography.button) {

                        Box(
                            modifier = Modifier
                                .defaultMinSize(
                                    minWidth = 56.dp,
                                    minHeight = 56.dp),
                            contentAlignment = Alignment.Center
                        ){
                            content()
                        }
                    }
                }
            }
        }
    }
}