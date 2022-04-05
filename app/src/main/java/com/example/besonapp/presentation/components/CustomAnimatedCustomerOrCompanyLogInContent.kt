package com.example.besonapp.presentation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.besonapp.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun CustomAnimatedCustomerOrCompanyLogInContent(
    title: String,
    details: String,
    button: String,
    imageUrl: String,
    surfaceColor: Color,
    targetOffsetValue: Float,
    closeLoginWindow: Boolean = false,
    onClick:() -> Unit,
){

    val offsetAnim = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = closeLoginWindow){

            offsetAnim.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = 1000
                )
            )

    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .offset(y = Dp(offsetAnim.value)),
        color = surfaceColor
    ) {
        val matrix = ColorMatrix()
        matrix.setToSaturation(0F)
        Image(
            modifier = Modifier.fillMaxSize(),
            painter =
            rememberImagePainter(
                request = ImageRequest
                    .Builder(LocalContext.current)
                    .data(imageUrl)
                    .build()
            ),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.colorMatrix(matrix),
            alpha = 0.1f
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h1)

                Text(
                    text = details,
                    style = MaterialTheme.typography.body1)

                val interactionSource = remember { MutableInteractionSource() }

                Surface(
                    modifier = Modifier
                        .width(200.dp)
                        .padding(top = 10.dp)
                        .clickable(interactionSource = interactionSource, indication = null) {

                            onClick()

                            coroutineScope.launch {
                                offsetAnim.animateTo(
                                    targetValue = targetOffsetValue,
                                    animationSpec = tween(
                                        durationMillis = 1000
                                    )
                                )
                            }
                        },
                    color = buttonBackgroundColor,
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, buttonBorder),
                    elevation = 8.dp
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            modifier = Modifier
                                .padding(6.dp),
                            color = selectCustomerOrCompanyScreenColor2,
                            text = button,
                            style = MaterialTheme.typography.button)
                    }
                }
            }
        }
    }
}