package com.example.besonapp.presentation.floating_components.common

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun BackToSignUpTextButton(
    contentAlignment: Alignment = Alignment.TopStart,
    onTextClick:() -> Unit
){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(
                vertical = 10.dp,
                horizontal = 10.dp),
        contentAlignment = contentAlignment
    ) {

        Text(
            modifier = Modifier.clickable {
                onTextClick()
            },
            text = "← Kayıt Sayfasına Geri Dön",
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
        )
    }

}