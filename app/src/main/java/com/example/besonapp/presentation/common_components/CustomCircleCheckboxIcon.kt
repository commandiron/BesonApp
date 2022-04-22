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
import androidx.compose.ui.unit.dp
import com.example.besonapp.ui.theme.primaryColorNoTheme

@Composable
fun CircleCheckbox(
    selected: Boolean) {

    val color = MaterialTheme.colors
    val imageVector = if (selected) Icons.Filled.CheckCircle else Icons.Outlined.Circle
    val tint = if (selected) primaryColorNoTheme else color.onBackground
    val background = if (selected) color.background else color.background

    Icon(
        imageVector = imageVector,
        tint = tint,
        modifier = Modifier
            .size(14.dp)
            .background(background, shape = CircleShape),
        contentDescription = "checkbox")
}