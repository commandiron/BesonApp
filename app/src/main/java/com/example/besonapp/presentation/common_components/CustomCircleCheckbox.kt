package com.example.besonapp.presentation.common_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.theme.primaryColorNoTheme

@Composable
fun CustomCircleCheckbox(
    selected: Boolean,
    selectedTint: Color = primaryColorNoTheme,
    unselectedTint: Color = MaterialTheme.colors.onBackground,
    selectedBackground: Color = MaterialTheme.colors.background,
    unSelectedBackground: Color = MaterialTheme.colors.background) {

    val imageVector = if (selected) Icons.Filled.CheckCircle else Icons.Outlined.Circle
    val tint = if (selected) selectedTint else unselectedTint
    val background = if (selected) selectedBackground else unSelectedBackground

    Icon(
        imageVector = imageVector,
        tint = tint,
        modifier = Modifier
            .size(14.dp)
            .background(background, shape = CircleShape),
        contentDescription = "checkbox")
}