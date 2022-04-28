package com.example.besonapp.presentation.common_components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.besonapp.presentation.model.ConstructionItem

@Composable
fun ConstructionItemView(
    data:ConstructionItem,
){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(80.dp),
            contentAlignment = Alignment.Center
        ){

            Icon(
                modifier = Modifier.size(60.dp),
                painter = rememberImagePainter(data = data.imageResource),
                contentDescription = null,
                tint = MaterialTheme.colors.onBackground)
        }

        Box(
            modifier = Modifier
                .size(80.dp, 20.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = data.title,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.caption.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
        }
    }
}