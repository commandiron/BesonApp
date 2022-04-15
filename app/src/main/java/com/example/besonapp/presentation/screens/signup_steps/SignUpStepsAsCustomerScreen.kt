package com.example.besonapp.presentation.screens.signup_steps_as_customer

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.besonapp.presentation.model.CustomerRegister
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.presentation.screens.signup_steps_as_customer.components.AlreadyMemberStripComponent
import com.example.besonapp.presentation.screens.signup_steps_as_customer.components.SignUpStepsClickableToGalleryImagePage
import com.example.besonapp.presentation.screens.signup_steps_as_customer.components.SignUpStepsTextFieldPage
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
fun SignUpStepsAsCustomerScreen(
    navController: NavController
) {

    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("")}
    var profilePictureUri by remember { mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 150.dp, bottom = 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Profil Oluştur",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2
        )

        // Remember a PagerState
        val pagerState = rememberPagerState()
        val coroutineScope = rememberCoroutineScope()

        //For start with page 0
        LaunchedEffect(key1 = Unit){
            pagerState.scrollToPage(0)
        }

        HorizontalPager(
            count = 3,
            state = pagerState,
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            userScrollEnabled = false
        ) { page ->

            when(page){

                0 -> {
                    SignUpStepsTextFieldPage(
                        modifier = Modifier,
                        entry = name,
                        title = "Adınızı giriniz.",
                        hint = "Adınız"
                    ){
                        name = it
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    }
                }

                1 -> {
                    SignUpStepsTextFieldPage(
                        modifier = Modifier,
                        entry = phoneNumber,
                        title = "Telefon numaranızı giriniz.",
                        hint = "Telefon no:",
                        keyboardType = KeyboardType.Phone
                    ){
                        phoneNumber = it
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    }
                }

                2 -> {
                    SignUpStepsClickableToGalleryImagePage(
                        modifier = Modifier,
                        buttonText = "Kaydı Tamamla"
                    ){
                        profilePictureUri = it.toString()

                        val userRegister = CustomerRegister(
                            name = name,
                            phoneNumber = phoneNumber,
                            profilePictureUri = profilePictureUri)

                        //Burada userRegister kaydı yapılacak ve profil sayfasına gidilecek.

                        navController.popBackStack()
                        navController.navigate(NavigationItem.Profile.screen_route)
                    }
                }
            }
        }

        BackHandler {
            coroutineScope.launch {
                if(pagerState.currentPage > 0){
                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                }else{
                    navController.popBackStack()
                }
            }
        }
    }
}