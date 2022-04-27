package com.example.besonapp.presentation.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.besonapp.presentation.common_components.ProfileHeader
import com.example.besonapp.presentation.common_components.ProfileScreenItemRow
import com.example.besonapp.presentation.navigation.NavigationItem
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    navController: NavController,
    isLoading:(Boolean)-> Unit){

    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()


    // İLGİNÇ BİR ŞEKİLDE BOTTOM SHEETİMİN DIŞARI DOKUNUNCA KAPANMASINI ENGELLEYEN BİR ŞEY VAR

    HorizontalPager(
        modifier = Modifier
            .focusable()
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = 36.dp),
        count = 2,
        state = pagerState,
        verticalAlignment = Alignment.Top,
        userScrollEnabled = false
    ) { page->

        when(page){

            0 -> {ProfileScreenMainPage(navController, coroutineScope, pagerState)}

            1 -> {ProfileScreenMyPriceUpdatesPage()}
        }
    }

    BackHandler {
        coroutineScope.launch {
            when (pagerState.currentPage) {
                1 -> { pagerState.animateScrollToPage(page = pagerState.currentPage - 1) }
                2 -> { pagerState.animateScrollToPage(page = pagerState.currentPage - 2) }
                else -> { navController.popBackStack() }
            }
        }
    }

}

@Composable
fun ProfileScreenMainPage(
    navController: NavController,
    coroutineScope: CoroutineScope,
    pagerState: PagerState
){
    var profileHeaderBoxHeight by remember { mutableStateOf(0)}

    val name by remember { mutableStateOf("İsim Soyad")}

    Column(
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {
        ProfileHeader(
            name = name,
            onEditButtonClick = {
                navController.navigate(NavigationItem.EditProfile.screen_route)
            },
            onVerticalDrag = {
                profileHeaderBoxHeight = it.minHeight
            }
        )
    }

    Column(
        modifier = Modifier.offset(y = with(LocalDensity.current){profileHeaderBoxHeight.toDp()}),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        ProfileScreenItemRow(
            title = "Fiyat Güncellemelerim"
        ){
            coroutineScope.launch {
                pagerState.animateScrollToPage(page = 1)
            }
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            color = MaterialTheme.colors.onPrimary,
            thickness = 1.dp
        )
    }

}

@Composable
fun ProfileScreenMyPriceUpdatesPage(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text(text = "ProfileScreenMyPriceUpdatesPage")
    }
}