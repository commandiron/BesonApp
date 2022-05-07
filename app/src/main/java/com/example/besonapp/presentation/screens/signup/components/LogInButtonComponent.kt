package com.example.besonapp.presentation.floating_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.ui.theme.logoBackGround
import com.example.besonapp.presentation.ui.theme.primaryColorNoTheme

@Composable
fun LogInButtonComponent(
    modifier: Modifier,
    text: String,
    onFloatingLogInButtonClick:() -> Unit
){
    Surface(
        modifier = modifier
            .clip(CircleShape)
            .size(100.dp, 50.dp),
        color = logoBackGround,
        shadowElevation = 5.dp,
        contentColor = primaryColorNoTheme
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {

            val interactionSource = remember { MutableInteractionSource() }

            Text(
                modifier = Modifier
                    .clickable(interactionSource,null) {
                    onFloatingLogInButtonClick()
                },
                text = text,
                style = MaterialTheme.typography.h4)
        }
    }
}