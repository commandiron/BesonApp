package com.example.besonapp.presentation.common_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreenItemRow(
    title: String,
    onRowClick:() -> Unit
){

    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        color = MaterialTheme.colors.onPrimary,
        thickness = 1.dp
    )

    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = Modifier
            .padding(horizontal = 40.dp)
            .clickable(interactionSource = interactionSource, indication = null) {
                onRowClick()
            },
        verticalAlignment = Alignment.CenterVertically) {

        Box(
            modifier = Modifier.weight(2f),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center)
        }
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.CenterEnd
        ) {
            Icon(
                imageVector = Icons.Default.ArrowRight,
                tint = MaterialTheme.colors.onBackground,
                contentDescription = null)
        }
    }
}