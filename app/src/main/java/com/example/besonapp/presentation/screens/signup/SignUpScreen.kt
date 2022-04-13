package com.example.besonapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.besonapp.presentation.CustomerOrCompanyComponent
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.presentation.common_components.SignUpFormComponent
import com.example.besonapp.presentation.floating_components.LogInButtonComponent
import com.example.besonapp.ui.theme.backgroundColorVariant1
import com.example.besonapp.ui.theme.backgroundColorVariant2
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_COMPANY_IMAGE_URL
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_COMPANY_LOGIN_BUTTON_TEXT
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_COMPANY_SIGNUP_BUTTON_TEXT
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_COMPANY_TEXT_BUTTON_TEXT
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_COMPANY_TEXT_DETAILS
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_COMPANY_TEXT_TITLE
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_CUSTOMER_IMAGE_URL
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_CUSTOMER_SIGNUP_BUTTON_TEXT
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_CUSTOMER_TEXT_BUTTON_TEXT
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_CUSTOMER_TEXT_DETAILS
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_CUSTOMER_TEXT_TITLE
import com.example.besonapp.util.SignUpAndLogInFormErrorHandle

@Composable
fun SignUpScreen(
    navController: NavController,
//    signUpViewModel: SignUpViewModel = hiltViewModel(),
    isSignUpScreenLogoClick: Boolean) {

    var customerWindowIsClosed by remember { mutableStateOf(true)}
    var companyWindowIsClosed by remember { mutableStateOf(true)}

    var customerSignUpComponentIsVisible by remember { mutableStateOf(false)}
    var companySignUpComponentIsVisible by remember { mutableStateOf(false)}

    LaunchedEffect(key1 = isSignUpScreenLogoClick){
        customerWindowIsClosed = true
        companyWindowIsClosed = true
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center) {

        val constraints = this.constraints

        Column{

            var signUpAndLogInFormErrorHandle by remember { mutableStateOf(
                SignUpAndLogInFormErrorHandle()
            )}

            Box(
                modifier = Modifier
                    .weight(1f)) {

                Surface(
                    color = MaterialTheme.colors.background
                ) {

                    if(customerSignUpComponentIsVisible){
                        SignUpFormComponent(
                            buttonText = SIGNUP_SCREEN_CUSTOMER_SIGNUP_BUTTON_TEXT,
                            signUpAndLogInFormErrorHandle = signUpAndLogInFormErrorHandle){

                            signUpAndLogInFormErrorHandle = SignUpAndLogInFormErrorHandle().invokeForSignUp(it) //Bu kısım viewModel'de halledilmeli

                            //Bu navigasyonda, bilgiler önce server'a gönderilecek ordan olumlu cevap gelirse navigate edilecek.
                            navController.navigate(NavigationItem.SignUpStepsAsCustomer.screen_route)
                        }
                    }

                    CustomerOrCompanyComponent(
                        title = SIGNUP_SCREEN_CUSTOMER_TEXT_TITLE,
                        details = SIGNUP_SCREEN_CUSTOMER_TEXT_DETAILS,
                        buttonText = SIGNUP_SCREEN_CUSTOMER_TEXT_BUTTON_TEXT,
                        imageUrl = SIGNUP_SCREEN_CUSTOMER_IMAGE_URL,
                        surfaceColor = backgroundColorVariant1,
                        targetOffsetValue = -constraints.maxHeight/4.toFloat() + 130f,
                        componentIsClosed = customerWindowIsClosed
                    ){
                        customerWindowIsClosed = false
                        companyWindowIsClosed = true

                        customerSignUpComponentIsVisible = true
                    }
                }
            }

            Box(
                modifier = Modifier
                    .weight(1f)) {

                Surface(
                    color = MaterialTheme.colors.background
                ) {

                    if(companySignUpComponentIsVisible){

                        SignUpFormComponent(
                            buttonText = SIGNUP_SCREEN_COMPANY_SIGNUP_BUTTON_TEXT,
                            paddingFromBottom = 56.dp,
                            signUpAndLogInFormErrorHandle = signUpAndLogInFormErrorHandle){

                            signUpAndLogInFormErrorHandle = SignUpAndLogInFormErrorHandle().invokeForSignUp(it) //Bu kısım viewModel'de halledilmeli

                            //Bu navigasyonda, bilgiler önce server'a gönderilecek ordan olumlu cevap gelirse navigate edilecek.
                            navController.navigate(NavigationItem.SignUpStepsAsCompany.screen_route)
                        }
                    }

                    CustomerOrCompanyComponent(
                        title = SIGNUP_SCREEN_COMPANY_TEXT_TITLE,
                        details = SIGNUP_SCREEN_COMPANY_TEXT_DETAILS,
                        buttonText = SIGNUP_SCREEN_COMPANY_TEXT_BUTTON_TEXT,
                        imageUrl = SIGNUP_SCREEN_COMPANY_IMAGE_URL,
                        surfaceColor = backgroundColorVariant2,
                        targetOffsetValue = constraints.maxHeight/4.toFloat() -130f,
                        componentIsClosed = companyWindowIsClosed
                    ){
                        companyWindowIsClosed = false
                        customerWindowIsClosed = true

                        companySignUpComponentIsVisible = true
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.CenterEnd
        ) {

            LogInButtonComponent(
                modifier = Modifier.padding(end = 10.dp),
                text = SIGNUP_SCREEN_COMPANY_LOGIN_BUTTON_TEXT
            ){
                customerSignUpComponentIsVisible = false
                companySignUpComponentIsVisible = false

                customerWindowIsClosed = false
                companyWindowIsClosed = false

                navController.navigate(NavigationItem.LogIn.screen_route)
            }
        }
    }
}