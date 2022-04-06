package com.example.besonapp.presentation.floating_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.example.besonapp.ui.theme.backgroundLight
import com.example.besonapp.util.StaticTexts.SIGNUP_SCREEN_COMPANY_LOGIN_BUTTON_TEXT

@Composable
fun FloatingLogInButtonComponent(
    onFloatingLogInButtonClick:() -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Surface(
            modifier = Modifier
                .padding(end = 10.dp)
                .clip(CircleShape)
                .size(100.dp, 50.dp),
            color = backgroundLight,
            contentColor = MaterialTheme.colors.onBackground
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {

                val interactionSource = remember { MutableInteractionSource() }

                Text(
                    modifier = Modifier.clickable(interactionSource,null) {
                        onFloatingLogInButtonClick()
                    },
                    text = SIGNUP_SCREEN_COMPANY_LOGIN_BUTTON_TEXT)
            }
        }
    }
}