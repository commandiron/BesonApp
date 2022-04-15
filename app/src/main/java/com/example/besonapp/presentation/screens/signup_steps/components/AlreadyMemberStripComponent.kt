package com.example.besonapp.presentation.screens.signup_steps_as_customer.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AlreadyMemberStripComponent(
    modifier: Modifier,
    color: Color = MaterialTheme.colors.onBackground,
    onTextClick:() -> Unit
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Divider(
            modifier = Modifier.width(60.dp),
            color = color,
            thickness = 1.dp)
        Text(
            modifier = Modifier.clickable {
                    onTextClick()
            },
            textAlign = TextAlign.Center,
            text = "Zaten Üyeyim",
            style = MaterialTheme.typography.body2.copy(color = color))
        Divider(
            modifier = Modifier.width(60.dp),
            color = color,
            thickness = 1.dp)
    }
}