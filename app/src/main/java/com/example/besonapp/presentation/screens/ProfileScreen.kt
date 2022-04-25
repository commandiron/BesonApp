package com.example.besonapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun ProfileScreen(
    navController: NavController,
    isLoading:(Boolean)-> Unit){

    //Bu kısım paddingsiz kısımdan paddingli kısma geçmek için zaten login olunca loading girecek.
    LaunchedEffect(key1 = Unit){
        isLoading(true)
        delay(1000)
        isLoading(false)

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        ClickableToGalleryImage()
    }
}