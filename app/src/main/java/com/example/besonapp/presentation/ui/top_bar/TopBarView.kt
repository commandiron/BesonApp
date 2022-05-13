package com.example.besonapp.presentation.topbar

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.ui.theme.onPrimaryColorNoTheme
import com.example.besonapp.presentation.ui.theme.primaryColorNoTheme
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues

@Composable
fun TopBarView(
    title: String
) {
    val statusBarHeight = rememberInsetsPaddingValues(insets = LocalWindowInsets.current.statusBars).calculateTopPadding()
    val topBarHeight = statusBarHeight + 36.dp

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(topBarHeight),
        color = primaryColorNoTheme,
        contentColor = onPrimaryColorNoTheme,
        elevation = 6.dp
    ) {
        Box(
            modifier = Modifier
                .padding(top = 14.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h3
            )
        }
    }
}