package com.example.besonapp.presentation.floating_components.signup_steps

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.AppLogoIconView
import com.example.besonapp.presentation.theme.primaryColorNoTheme
import com.example.besonapp.util.AppStaticTexts


@Composable
fun FloatingLogoWithAppName(
    contentAlignment: Alignment = Alignment.BottomCenter
){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(bottom = 40.dp),
        contentAlignment = contentAlignment
    ) {
        Row(
            modifier = Modifier.padding(vertical = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppLogoIconView(
                sizeAnimValue = 30.dp,
                tint = primaryColorNoTheme,
            )

            Text(
                text = AppStaticTexts.APP_NAME,
                color = primaryColorNoTheme,
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Bottom)
            )
        }
    }
}