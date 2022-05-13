package com.example.besonapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.besonapp.presentation.CustomerOrCompanyComponent
import com.example.besonapp.presentation.ui.navigation.NavigationItem
import com.example.besonapp.presentation.common_components.SignUpFormComponent
import com.example.besonapp.presentation.floating_components.LogInButtonComponent
import com.example.besonapp.presentation.model.UserType
import com.example.besonapp.presentation.screens.signup.SignUpViewModel
import com.example.besonapp.presentation.ui.theme.backgroundColorVariantSignUpCustomer
import com.example.besonapp.presentation.ui.theme.backgroundColorVariantSignUpCompany
import com.example.besonapp.util.AppStaticTexts.COMPANY_STATEMENT_TEXT
import com.example.besonapp.util.AppStaticTexts.CUSTOMER_STATEMENT_TEXT
import com.example.besonapp.util.AppStaticTexts.I_AM_COMPANY_TEXT
import com.example.besonapp.util.AppStaticTexts.I_AM_CUSTOMER_TEXT
import com.example.besonapp.util.AppStaticTexts.LOGIN_TEXT
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_COMPANY_IMAGE_URL
import com.example.besonapp.util.AppStaticTexts.SIGNUP_SCREEN_CUSTOMER_IMAGE_URL
import com.example.besonapp.util.AppStaticTexts.SIGNUP_UPPERCASE_TEXT
import com.example.besonapp.util.AppStaticTexts.SIGN_UP_AS_COMPANY_TEXT
import com.example.besonapp.util.AppStaticTexts.SIGN_UP_AS_CUSTOMER_TEXT

@Composable
fun SignUpScreen(
    navController: NavController,
    signUpViewModel: SignUpViewModel = hiltViewModel(),
    isSignUpScreenLogoClick: Boolean
) {
    val isUserSignUp = signUpViewModel.isUserSignUp.value

    LaunchedEffect(key1 = isUserSignUp){
        if(isUserSignUp != null){
            if(isUserSignUp == UserType.CUSTOMER){
                navController.navigate(NavigationItem.SignUpStepsAsCustomer.screen_route)
            }else if(isUserSignUp == UserType.COMPANY){
                navController.navigate(NavigationItem.SignUpStepsAsCompany.screen_route)
            }
        }
    }

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
        contentAlignment = Alignment.Center
    ) {
        val constraints = this.constraints
        Column{
            val signUpValidationState by signUpViewModel.signUpFormValidationState
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    if(customerSignUpComponentIsVisible){
                        SignUpFormComponent(
                            buttonText = SIGN_UP_AS_CUSTOMER_TEXT,
                            signUpAndLogInInfoValidation = signUpValidationState){

                            signUpViewModel.signUp(it,UserType.CUSTOMER)
                        }
                    }
                    CustomerOrCompanyComponent(
                        title =  I_AM_CUSTOMER_TEXT,
                        details = CUSTOMER_STATEMENT_TEXT,
                        buttonText = SIGNUP_UPPERCASE_TEXT,
                        imageUrl = SIGNUP_SCREEN_CUSTOMER_IMAGE_URL,
                        surfaceColor = backgroundColorVariantSignUpCustomer,
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
                    .weight(1f)
            ) {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    if(companySignUpComponentIsVisible){
                        SignUpFormComponent(
                            buttonText = SIGN_UP_AS_COMPANY_TEXT,
                            paddingFromBottom = 56.dp,
                            signUpAndLogInInfoValidation = signUpValidationState
                        ){
                            signUpViewModel.signUp(it, UserType.COMPANY)
                        }
                    }
                    CustomerOrCompanyComponent(
                        title = I_AM_COMPANY_TEXT,
                        details = COMPANY_STATEMENT_TEXT,
                        buttonText = SIGNUP_UPPERCASE_TEXT,
                        imageUrl = SIGNUP_SCREEN_COMPANY_IMAGE_URL,
                        surfaceColor = backgroundColorVariantSignUpCompany,
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
                text = LOGIN_TEXT
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