package com.example.besonapp.presentation.screens.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.google.accompanist.pager.HorizontalPagerIndicator
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.besonapp.R
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.ui.theme.backgroundLight
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@Composable
fun IntroScreen(navController: NavController){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                rememberInsetsPaddingValues(
                    insets = LocalWindowInsets.current.systemBars,
                    applyTop = true,
                    applyBottom = true,
                )
            ),
        contentAlignment = Alignment.Center) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            val pagerState = rememberPagerState()

            // Display 10 items
            HorizontalPager(
                count = 4,
                state = pagerState,
                // Add 32.dp horizontal padding to 'center' the pages
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier
                    .fillMaxWidth(),
            ) { page ->

                PagerSampleItem(
                    page = page,
                    modifier = Modifier
                        .size(260.dp,548.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(20.dp))
            
            HorizontalPagerIndicator(
                pagerState = pagerState,
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.navigate(NavigationItem.SignUp.screenRoute)
                },
            color = MaterialTheme.colors.primary) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "HEMEN BAŞLA",
                    color = backgroundLight,
                    style = MaterialTheme.typography.h3)
            }
        }
    }


}

@Composable
internal fun PagerSampleItem(
    page: Int,
    modifier: Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,) {

        var imageUrl by remember { mutableStateOf(0)}
        var textByPage by remember { mutableStateOf("")}
        var textPadding by remember { mutableStateOf(0f)}

        when(page){
            0 ->{
                imageUrl = R.drawable.screenshot_1
                textByPage = "BEŞON BİR GÜNCEL İNŞAAT FİYATLARI PLATFORMUDUR."
                textPadding = 580f}
            1 ->{
                imageUrl =  R.drawable.screenshot_2
                textByPage = "İSTER MÜŞTERİ OLARAK GÜNCEL İNŞAAT FİYATLARINI TAKİP ET VE İŞİNİ YAPTIRACAK FİRMA BUL"
                textPadding = 580f}
            2 ->{
                imageUrl = R.drawable.screenshot_3
                textByPage = "İSTER FİRMA OLARAK FİYATLARIN GÜNCEL KALMASINA DESTEK VER VE MÜŞTERİ BUL."
                textPadding = 580f}
            3 ->{
                imageUrl = R.drawable.screenshot_4
                textByPage = "HEMDE BEDAVA"
                textPadding = 340f}
        }

        Column() {
            Image(
                modifier = modifier,
                painter = rememberImagePainter(
                    data = imageUrl,
                ),
                contentScale = ContentScale.Fit,
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(30.dp))
        }

        Box(modifier = Modifier.padding(top = Dp(textPadding))) {
            Text(
                text = textByPage,
                color = Color.White,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center)
        }


    }
}