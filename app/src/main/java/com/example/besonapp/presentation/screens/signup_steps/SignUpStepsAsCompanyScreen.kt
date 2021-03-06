package com.example.besonapp.presentation.screens.signup_steps_as_company

import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.besonapp.presentation.model.MainConstructionItem
import com.example.besonapp.presentation.screens.signup_steps.SignUpStepsViewModel
import com.example.besonapp.presentation.ui.navigation.NavigationItem
import com.example.besonapp.presentation.screens.signup_steps.components.SignUpStepsCategorySelectionPage
import com.example.besonapp.presentation.screens.signup_steps_as_customer.components.SignUpStepsClickableToGalleryImagePage
import com.example.besonapp.presentation.screens.signup_steps_as_customer.components.SignUpStepsTextFieldPage
import com.example.besonapp.util.AppStaticTexts.COMPLETE_REGISTRATION_TEXT
import com.example.besonapp.util.AppStaticTexts.CREATE_PROFILE_TEXT
import com.example.besonapp.util.AppStaticTexts.ENTER_YOUR_NAME_OR_COMPANY_TEXT
import com.example.besonapp.util.AppStaticTexts.ENTER_YOUR_PHONE_NUMBER_TEXT
import com.example.besonapp.util.AppStaticTexts.NEXT_TEXT
import com.example.besonapp.util.AppStaticTexts.SELECT_MAIN_CONSTRUCTION_CATEGORY_TEXT
import com.example.besonapp.util.AppStaticTexts.SELECT_PROFILE_PICTURE_TEXT
import com.example.besonapp.util.AppStaticTexts.SELECT_SUB_CONSTRUCTION_CATEGORY_TEXT
import com.example.besonapp.util.AppStaticTexts.YOUR_NAME_TEXT
import com.example.besonapp.util.AppStaticTexts.YOUR_PHONE_NUMBER_TEXT
import com.example.besonapp.util.AppStaticTexts.YOU_CAN_SELECT_MULTIPLE_CATEGORIES_TEXT
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
fun SignUpStepsAsCompanyScreen(
    navController: NavController,
    signUpStepsViewModel: SignUpStepsViewModel = hiltViewModel()
) {
    val isProfileUpdated by signUpStepsViewModel.isCompanyProfileUpdated

    LaunchedEffect(key1 = isProfileUpdated){
        if(isProfileUpdated){
            navController.navigate(NavigationItem.Profile.screen_route)
        }
    }

    var nameOrCompanyName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var profilePictureUri by remember { mutableStateOf<Uri?>(null) }
    val mainConstructionCategories by signUpStepsViewModel.mainConstructionCategoriesState

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
        var selectedMainCategory by remember { mutableStateOf<MainConstructionItem?>(null)}

        HorizontalPager(
            count = 5,
            state = pagerState,
            modifier = Modifier
                .wrapContentSize(),
            verticalAlignment = Alignment.Top,
            userScrollEnabled = false,
        ) { page ->
            when(page){
                0 -> {
                    SignUpStepsTextFieldPage(
                        entry = nameOrCompanyName,
                        title = ENTER_YOUR_NAME_OR_COMPANY_TEXT,
                        hint = YOUR_NAME_TEXT
                    ){
                        nameOrCompanyName = it
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    }
                }
                1 -> {
                    SignUpStepsTextFieldPage(
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
                        title = SELECT_PROFILE_PICTURE_TEXT,
                        buttonText = NEXT_TEXT
                    ){
                        profilePictureUri = it
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    }
                }
                3 -> {
                    SignUpStepsCategorySelectionPage(
                        title = SELECT_MAIN_CONSTRUCTION_CATEGORY_TEXT,
                        itemListMain = mainConstructionCategories,
                        buttonText = NEXT_TEXT,
                        multipleSelectionEnabled = false,
                        onNextButtonClickSingleSelection = { selectedItem ->
                            if(selectedItem != null){
                                selectedMainCategory = selectedItem as MainConstructionItem
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(page + 1)
                                }
                            }else{
                             //SE????M YAPMADINIZ
                            }
                        }
                    )
                }
                4 -> {
                    SignUpStepsCategorySelectionPage(
                        title = SELECT_SUB_CONSTRUCTION_CATEGORY_TEXT,
                        underButtonHintText = YOU_CAN_SELECT_MULTIPLE_CATEGORIES_TEXT,
                        itemListMain = selectedMainCategory?.subConstructionCategories ?: emptyList(),
                        buttonText = COMPLETE_REGISTRATION_TEXT,
                        multipleSelectionEnabled = true,
                        onNextButtonClickMultipleSelection = { selectedItemList ->
                            if(selectedItemList != null){
                                signUpStepsViewModel.createCompanyProfile(
                                    name = nameOrCompanyName,
                                    phoneNumber = phoneNumber,
                                    profilePictureUri = profilePictureUri,
                                    mainConstructionItemId = selectedMainCategory!!.id,
                                    subConstructionItemIdList = selectedItemList.map { it.id }
                                )
                            }else{
                                //SE????M YAPMADINIZ
                            }
                        }
                    )
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