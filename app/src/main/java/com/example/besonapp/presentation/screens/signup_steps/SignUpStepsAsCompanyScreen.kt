package com.example.besonapp.presentation.screens.signup_steps_as_company

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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

        //Page 3 variable, burası viewmodele taşınacak.
        var selectedMainCategoryId by remember { mutableStateOf(0)}

        //Page 4 variable, burası viewmodele taşınacak.
        var selectedSubCategoryList by remember { mutableStateOf<List<ConstructionItem>>(emptyList())}

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
                        entry = phoneNumber,
                        title = "Telefon numaranızı giriniz.",
                        hint = "Telefon no",
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
                        buttonText = "İleri"
                    ){
                        profilePictureUri = it.toString()

                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                    }
                }

                3 -> {

                    //Bu kısım viewmodel'den gelmeli
                    val mainConstructionCatagories = ConstructionItem.createMainCatagoryList()

                    SignUpStepsCategorySelectionPage(
                        title = "Ana Kategori Seçiniz",
                        itemList = mainConstructionCatagories,
                        buttonText = "İleri",
                        multipleSelectionEnabled = false,
                        onNextButtonClickSingleSelection = { selectedItem ->

                            if(selectedItem != null){

                                //Bu kısım viewmodel'e gönderilmeli
                                    //getSubConstructionCategory fonksiyonu ile çağırılacak.
                                selectedMainCategoryId = selectedItem.id

                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(page + 1)
                                }
                            }else{
                             //SEÇİM YAPMADINIZ
                            }
                        }
                    )
                }

                4 -> {

                    //Bu kısım viewmodel'den gelmeli
                    val subConstructionCatagories = ConstructionItem.createSubCatagoryList()

                    SignUpStepsCategorySelectionPage(
                        title = "Alt Kategori Seçiniz",
                        itemList = subConstructionCatagories[selectedMainCategoryId] ?: emptyList(),
                        buttonText = "Kaydı Tamamla",
                        multipleSelectionEnabled = true,
                        onNextButtonClickMultipleSelection = { selectedItemList ->

                            if(selectedItemList != null){

                                //Bu kısımda viewmodel'e gönderilip kayıt yapılacak.
                                selectedSubCategoryList = selectedItemList

                                val companyRegister = CompanyRegister(
                                    nameOrCompanyName = nameOrCompanyName,
                                    phoneNumber = phoneNumber,
                                    profilePictureUri = profilePictureUri,
                                    selectedSubCategoryList = selectedSubCategoryList
                                )

                                navController.popBackStack()
                                navController.navigate(NavigationItem.Profile.screen_route)
                            }else{
                                //SEÇİM YAPMADINIZ
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