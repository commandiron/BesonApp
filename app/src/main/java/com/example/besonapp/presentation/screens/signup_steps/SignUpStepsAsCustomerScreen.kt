package com.example.besonapp.presentation.screens.signup_steps_as_customer

import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.besonapp.presentation.screens.signup_steps.SignUpStepsViewModel
import com.example.besonapp.presentation.screens.signup_steps_as_customer.components.SignUpStepsClickableToGalleryImagePage
import com.example.besonapp.presentation.screens.signup_steps_as_customer.components.SignUpStepsTextFieldPage
import com.example.besonapp.presentation.ui.navigation.NavigationItem
import com.example.besonapp.util.AppStaticTexts.COMPLETE_REGISTRATION_TEXT
import com.example.besonapp.util.AppStaticTexts.CREATE_PROFILE_TEXT
import com.example.besonapp.util.AppStaticTexts.ENTER_YOUR_NAME_TEXT
import com.example.besonapp.util.AppStaticTexts.ENTER_YOUR_PHONE_NUMBER_TEXT
import com.example.besonapp.util.AppStaticTexts.SELECT_PROFILE_PICTURE_TEXT
import com.example.besonapp.util.AppStaticTexts.YOUR_NAME_TEXT
import com.example.besonapp.util.AppStaticTexts.YOUR_PHONE_NUMBER_TEXT
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
fun SignUpStepsAsCustomerScreen(
    navController: NavController,
    signUpStepsViewModel: SignUpStepsViewModel = hiltViewModel()
) {

    val isProfileUpdated by signUpStepsViewModel.isCustomerProfileUpdated

    LaunchedEffect(key1 = isProfileUpdated){
        if(isProfileUpdated){
            navController.navigate(NavigationItem.Profile.screen_route)
        }
    }

    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("")}
    var profilePictureUri by remember { mutableStateOf<Uri?>(null)}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(
                top = 100.dp,
                start = 10.dp,
                end = 10.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = CREATE_PROFILE_TEXT,
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2
        )

        Spacer(modifier = Modifier.height(20.dp))

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
                .wrapContentSize(),
            verticalAlignment = Alignment.Top,
            userScrollEnabled = false
        ) { page ->

            when(page){

                0 -> {
                    SignUpStepsTextFieldPage(
                        modifier = Modifier,
                        entry = name,
                        title = ENTER_YOUR_NAME_TEXT,
                        hint = YOUR_NAME_TEXT
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
                        title = ENTER_YOUR_PHONE_NUMBER_TEXT,
                        hint = YOUR_PHONE_NUMBER_TEXT,
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
                        title = SELECT_PROFILE_PICTURE_TEXT,
                        buttonText = COMPLETE_REGISTRATION_TEXT
                    ){
                        profilePictureUri = it

                        signUpStepsViewModel.createCustomerProfile(
                            name = name,
                            phoneNumber = phoneNumber,
                            profilePictureUri = profilePictureUri)
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