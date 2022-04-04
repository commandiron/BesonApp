package com.example.besonapp.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.besonapp.ui.theme.*

@Composable
fun CustomCustomerOrCompanyContent(
    title: String,
    details: String,
    button: String,
    onButtonClick:() -> Unit
){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h1)

            Text(
                text = details,
                style = MaterialTheme.typography.body1)

            val interactionSource = remember { MutableInteractionSource() }

            Surface(
                modifier = Modifier
                    .width(200.dp)
                    .padding(top = 10.dp)
                    .clickable(interactionSource = interactionSource, indication = null) {
                        onButtonClick()
                    },
                color = buttonBackgroundColor,
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, buttonBorder),
                elevation = 8.dp
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        modifier = Modifier
                            .padding(6.dp),
                        color = selectCustomerOrCompanyScreenColor2,
                        text = button,
                        style = MaterialTheme.typography.button)
                }
            }
        }
    }
}