package com.example.besonapp.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardDoubleArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues


@Composable
fun NavigationTutorialProfileScreen(
    enabled: Boolean = true
) {

    var tutorialEnabled by remember { mutableStateOf(enabled)}
    var nextClicked by remember { mutableStateOf(0)}

    var screenSize by remember { mutableStateOf(Size(0f,0f))}

    val navigationHeight = rememberInsetsPaddingValues(insets = LocalWindowInsets.current.navigationBars).calculateBottomPadding()
    val navigationHeightPx = with(LocalDensity.current){navigationHeight.toPx()}
    val statusBarHeight = rememberInsetsPaddingValues(insets = LocalWindowInsets.current.statusBars).calculateTopPadding()
    val statusBarHeightPx = with(LocalDensity.current){statusBarHeight.toPx()}

    var highlightCircleSize by remember { mutableStateOf(Size(0f, 0f))}
    var highlightCirclePaddingXFromStart by remember { mutableStateOf(0f)}
    var highlightCirclePaddingYFromTop by remember { mutableStateOf(0f)}

    var infoRectangleSize by remember { mutableStateOf(Size(0f,0f))}
    var infoRectanglePaddingXFromStart by remember { mutableStateOf(0f)}
    var infoRectanglePaddingYFromTop by remember { mutableStateOf(0f)}

    var infoText by remember { mutableStateOf("")}
    val infoTextAnimationAlphaDuration = 1000
    val textAlphaAnim = remember { Animatable(0f) }

    if(tutorialEnabled){

        when(nextClicked){

            0 -> {

                highlightCircleSize = Size(
                    width = screenSize.height / 14,
                    height = screenSize.height / 14
                )

                LaunchedEffect(key1 = screenSize){

                    infoRectangleSize = Size(
                        width = screenSize.width * 0.24f,
                        height = screenSize.height * 0.08f)

                    infoRectanglePaddingXFromStart =  - screenSize.width * 0.25f
                    infoRectanglePaddingYFromTop = screenSize.height * 0.83f

                    highlightCirclePaddingXFromStart =  - screenSize.width * 0.25f
                    highlightCirclePaddingYFromTop = screenSize.height * 0.924f

                    infoText = "Profilini Görüntüle"

                    textAlphaAnim.animateTo(
                        targetValue = 1f,
                        animationSpec = repeatable(
                            iterations = 3,
                            animation = tween(
                                durationMillis = infoTextAnimationAlphaDuration
                            )
                        )
                    )
                }
            }

            1 ->{

                highlightCircleSize = Size(
                    width = screenSize.height / 10,
                    height = screenSize.height / 10
                )

                LaunchedEffect(key1 = Unit){

                    infoRectangleSize = Size(
                            width = screenSize.width *  0.24f,
                            height = screenSize.height * 0.08f
                    )

                    infoRectanglePaddingXFromStart = 0f
                    infoRectanglePaddingYFromTop = screenSize.height * 0.79f

                    highlightCirclePaddingXFromStart = 0f
                    highlightCirclePaddingYFromTop = screenSize.height * 0.875f

                    infoText = "Fiyat Gir"

                    textAlphaAnim.animateTo(0f)
                    textAlphaAnim.animateTo(
                        targetValue = 1f,
                        animationSpec = repeatable(
                            iterations = 3,
                            animation = tween(
                                durationMillis = infoTextAnimationAlphaDuration
                            )
                        )
                    )
                }
            }
            2 -> {

                highlightCircleSize = Size(
                    width = screenSize.height / 14,
                    height = screenSize.height / 14
                )

                LaunchedEffect(key1 = Unit){

                    infoRectangleSize = Size(
                        width = screenSize.width * 0.24f,
                        height = screenSize.height * 0.08f
                    )

                    infoRectanglePaddingXFromStart = screenSize.width * 0.25f
                    infoRectanglePaddingYFromTop = screenSize.height * 0.83f

                    highlightCirclePaddingXFromStart = screenSize.width * 0.25f
                    highlightCirclePaddingYFromTop = screenSize.height * 0.924f

                    infoText = "Fiyatları Görüntüle"

                    textAlphaAnim.animateTo(0f)
                    textAlphaAnim.animateTo(
                        targetValue = 1f,
                        animationSpec = repeatable(
                            iterations = 3,
                            animation = tween(
                                durationMillis = infoTextAnimationAlphaDuration
                            )
                        )
                    )
                }
            }
            3 -> {
                tutorialEnabled = false
            }
        }


        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {

            Column(
                modifier = Modifier
                    .offset(
                        x = with(LocalDensity.current) { infoRectanglePaddingXFromStart.toDp() },
                        y = with(LocalDensity.current) { infoRectanglePaddingYFromTop.toDp() + statusBarHeightPx.toDp() })
                    .size(
                        with(LocalDensity.current) { infoRectangleSize.width.toDp() },
                        with(LocalDensity.current) { infoRectangleSize.height.toDp() }
                    )
                    .alpha(textAlphaAnim.value),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = infoText,
                    color = MaterialTheme.colors.onPrimary
                )
                Icon(
                    imageVector = Icons.Default.KeyboardDoubleArrowDown,
                    tint = MaterialTheme.colors.onPrimary,
                    contentDescription = null
                )
            }
        }

        val interactionSource = remember { MutableInteractionSource() }

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    nextClicked++
                }
                .drawWithContent {

                    val path = Path().apply {

                        screenSize = Size(width = size.width, height = size.height - (statusBarHeightPx + navigationHeightPx))

                        addOval(
                            Rect(
                                offset =
                                        Offset(
                                            //Centralize
                                            x = screenSize.width / 2 - highlightCircleSize.width / 2,
                                            y = statusBarHeightPx)

                                            //Offset
                                        + Offset(
                                            x = highlightCirclePaddingXFromStart,
                                            y = highlightCirclePaddingYFromTop)
                                ,
                                size = highlightCircleSize
                            )
                        )

                        addRect(
                            Rect(
                                offset =
                                        Offset(
                                            //Centralize
                                            x = screenSize.width / 2 -infoRectangleSize.width / 2,
                                            y = statusBarHeightPx)

                                            //Offset
                                        + Offset(
                                            x = infoRectanglePaddingXFromStart,
                                            y = infoRectanglePaddingYFromTop)
                                ,
                                size = infoRectangleSize
                            )
                        )
                    }

                    clipPath(path, clipOp = ClipOp.Difference) {

                        //Burada backgroundDark rengi gelirse daha güzel olabilir, şimdilik rahat görmek
                        //için black yaptım.
                        drawRect(SolidColor(Color.Black.copy(0.5f)))
                    }
                }
        ){}
    }
}