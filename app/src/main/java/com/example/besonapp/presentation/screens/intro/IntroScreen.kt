package com.example.besonapp.presentation.screens.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import com.google.accompanist.pager.HorizontalPagerIndicator
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.besonapp.util.IntroScreenElement
import com.example.besonapp.presentation.ui.navigation.NavigationItem
import com.example.besonapp.presentation.ui.theme.onPrimaryColorNoTheme
import com.example.besonapp.presentation.ui.theme.primaryColorNoTheme
import com.example.besonapp.presentation.ui.theme.primaryVariantColorNoTheme
import com.example.besonapp.util.AppStaticTexts.START_NOW_TEXT
import com.example.besonapp.util.AppStaticTexts.START_TEXT
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@Composable
fun IntroScreen(
    navController: NavController,
    introViewModel: IntroViewModel = hiltViewModel()
){
    var lastPageFlag by remember { mutableStateOf(false)}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.BottomCenter),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val pagerState = rememberPagerState()
        //Bu kısım daha sonra viewmodelden çekilip buraya gönderilecek.
        val listOfIntroElement by remember{ mutableStateOf(IntroScreenElement.staticIntroElementList)}
        HorizontalPager(
            count = listOfIntroElement.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = Modifier
                .fillMaxWidth(),
        ) { numberOfPage->
            PagerItem(
                introScreenElementList = listOfIntroElement,
                numberOfPage = numberOfPage
            )
            lastPageFlag = pagerState.currentPage == listOfIntroElement.size - 1
        }
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalPagerIndicator(
            pagerState = pagerState,
            activeColor = if(lastPageFlag) primaryVariantColorNoTheme else primaryColorNoTheme,
            inactiveColor = if(lastPageFlag) primaryVariantColorNoTheme.copy(0.5f) else primaryColorNoTheme.copy(0.5f)
        )
        Spacer(modifier = Modifier.height(30.dp))
        val navigationBarHeight = rememberInsetsPaddingValues(insets = LocalWindowInsets.current.navigationBars).calculateBottomPadding()
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp + navigationBarHeight)
                .clickable {
                    navController.navigate(NavigationItem.SignUp.screen_route)
                    introViewModel.setUserOpenAppOnceFlagTrue()
                },
            color = if(lastPageFlag) primaryVariantColorNoTheme else primaryColorNoTheme
        ) {
            Text(
                modifier = Modifier.padding(top = 18.dp),
                textAlign = TextAlign.Center,
                text = if(lastPageFlag) START_TEXT else START_NOW_TEXT,
                color = onPrimaryColorNoTheme,
                style = MaterialTheme.typography.h3
            )
        }
    }
}

@Composable
fun PagerItem(
    introScreenElementList: List<IntroScreenElement>,
    numberOfPage: Int,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(260.dp,548.dp),
            painter = rememberImagePainter(
                data = introScreenElementList[numberOfPage].imageResource,
            ),
            contentScale = ContentScale.Fit,
            contentDescription = null
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = introScreenElementList[numberOfPage].explanationText,
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center
            )
        }
    }
}