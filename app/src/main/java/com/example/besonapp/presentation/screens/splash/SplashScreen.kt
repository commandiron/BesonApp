package com.example.besonapp

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.besonapp.presentation.CustomAppExplainingTape
import com.example.besonapp.presentation.util.StaticTexts.APP_STATEMENT
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(Unit) {

        delay(4600)

        navController.popBackStack()
        navController.navigate(NavigationItem.Login.screenRoute)
    }


        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            CustomAppExplainingTape(APP_STATEMENT) //BU TAPE KISMINI BELKİ FOTOĞRAFIN ÜZERİNDEN GEÇİREBİLİRİM.
        }

}
