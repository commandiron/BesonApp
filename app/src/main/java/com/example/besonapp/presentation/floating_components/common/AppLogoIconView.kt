package com.example.besonapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DocumentScanner
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.besonapp.ui.theme.logoColor

@Composable
fun AppLogoIconView(
    modifier: Modifier = Modifier,
    tint: Color = logoColor,
    sizeAnimValue:Dp = 100.dp,
    alphaAnimValue:Float = 1f,
    rotateAnimValue:Float = 0f){

    Icon(
        modifier = modifier
            .size(sizeAnimValue)
            .alpha(alphaAnimValue)
            .rotate(rotateAnimValue),
        imageVector = Icons.Default.DocumentScanner,
        contentDescription = null,
        tint = tint
    )
}

