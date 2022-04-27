package com.example.besonapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.besonapp.presentation.theme.onPrimaryColorNoTheme
import com.example.besonapp.presentation.theme.primaryColorNoTheme

@Composable
fun UpdatePricesScreen(navController: NavController){


    Surface(
        modifier = Modifier
            .heightIn(max = 400.dp),
        color = primaryColorNoTheme,
        contentColor = onPrimaryColorNoTheme
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Text("1")
            }
        }
    }
}