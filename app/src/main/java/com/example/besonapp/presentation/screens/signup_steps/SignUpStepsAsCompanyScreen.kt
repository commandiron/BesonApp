package com.example.besonapp.presentation.screens.signup_steps_as_company

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.besonapp.presentation.model.CompanyRegister
import com.example.besonapp.presentation.model.ConstructionItem
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.presentation.screens.signup_steps.components.SignUpStepsCategorySelectionPage
import com.example.besonapp.presentation.screens.signup_steps_as_customer.components.SignUpStepsClickableToGalleryImagePage
import com.example.besonapp.presentation.screens.signup_steps_as_customer.components.SignUpStepsTextFieldPage
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
fun SignUpStepsAsCompanyScreen(
    navController: NavController
) {

    var nameOrCompanyName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var profilePictureUri by remember { mutableStateOf("") }

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

        var selectedMainCategoryId by remember { mutableStateOf(0)}

        HorizontalPager(
            count = 5,
            state = pagerState,
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            userScrollEnabled = false,
        ) { page ->

            when(page){

                0 -> {
                    SignUpStepsTextFieldPage(
                        modifier = Modifier,
                        entry = nameOrCompanyName,
                        title = "Adınızı ya da şirket adınızı giriniz.",
                        hint = "Adınız"
                    ){
                        nameOrCompanyName = it
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
                        hint = "Telefon no"
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
                        buttonText = "İleri"
                    ){
                        profilePictureUri = it.toString()

                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    }
                }

                3 -> {

                    val mainConstructionCatagories = ConstructionItem.createMainCatagoryList()

                    SignUpStepsCategorySelectionPage(mainConstructionCatagories){ selectedItemId ->

                        selectedMainCategoryId = selectedItemId

                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    }
                }

                4 -> {

                    val subConstructionCatagories = ConstructionItem.createSubCatagoryList()

                    SignUpStepsCategorySelectionPage(subConstructionCatagories[selectedMainCategoryId]!!){ selectedItemList ->

                        val companyRegister = CompanyRegister(
                            nameOrCompanyName = nameOrCompanyName,
                            phoneNumber = phoneNumber,
                            profilePictureUri = profilePictureUri)

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