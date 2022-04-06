package com.example.besonapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.besonapp.presentation.CustomerOrCompanyComponent
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.presentation.common_components.SignUpFormComponent
import com.example.besonapp.presentation.floating_components.FloatingLogInButtonComponent
import com.example.besonapp.ui.theme.backgroundColorVariant1
import com.example.besonapp.ui.theme.backgroundLight
import com.example.besonapp.ui.theme.backgroundColorVariant2
import com.example.besonapp.util.StaticTexts.SIGNUP_SCREEN_COMPANY_IMAGE_URL
import com.example.besonapp.util.StaticTexts.SIGNUP_SCREEN_COMPANY_SIGNUP_BUTTON_TEXT
import com.example.besonapp.util.StaticTexts.SIGNUP_SCREEN_COMPANY_TEXT_BUTTON_TEXT
import com.example.besonapp.util.StaticTexts.SIGNUP_SCREEN_COMPANY_TEXT_DETAILS
import com.example.besonapp.util.StaticTexts.SIGNUP_SCREEN_COMPANY_TEXT_TITLE
import com.example.besonapp.util.StaticTexts.SIGNUP_SCREEN_CUSTOMER_IMAGE_URL
import com.example.besonapp.util.StaticTexts.SIGNUP_SCREEN_CUSTOMER_SIGNUP_BUTTON_TEXT
import com.example.besonapp.util.StaticTexts.SIGNUP_SCREEN_CUSTOMER_TEXT_BUTTON_TEXT
import com.example.besonapp.util.StaticTexts.SIGNUP_SCREEN_CUSTOMER_TEXT_DETAILS
import com.example.besonapp.util.StaticTexts.SIGNUP_SCREEN_CUSTOMER_TEXT_TITLE

@Composable
fun SignUpScreen(
    navController: NavController,
    isSignUpScreenLogoClick: Boolean) {

    var customerWindowIsClosed by remember { mutableStateOf(true)}
    var companyWindowIsClosed by remember { mutableStateOf(true)}

    var customerSignUpComponentIsVisible by remember { mutableStateOf(false)}
    var companySignUpComponentIsVisible by remember { mutableStateOf(false)}

    LaunchedEffect(key1 = isSignUpScreenLogoClick){
        customerWindowIsClosed = true
        companyWindowIsClosed = true
    }

    Box(
        contentAlignment = Alignment.Center) {

        BoxWithConstraints(
            contentAlignment = Alignment.Center) {

            val constraints = this.constraints

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)) {

                    Surface(
                        color = backgroundLight
                    ) {

                        if(customerSignUpComponentIsVisible){
                            SignUpFormComponent(SIGNUP_SCREEN_CUSTOMER_SIGNUP_BUTTON_TEXT){
                                //Müşteri olarak giriş yaptır ya da kayıt oldur.
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
                        color = backgroundLight
                    ) {

                        if(companySignUpComponentIsVisible){

                            SignUpFormComponent(SIGNUP_SCREEN_COMPANY_SIGNUP_BUTTON_TEXT, 56.dp){
                                //Firma olarak giriş yaptır ya da kayıt oldur.
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
        }

        FloatingLogInButtonComponent(){
            customerSignUpComponentIsVisible = false
            companySignUpComponentIsVisible = false

            customerWindowIsClosed = false
            companyWindowIsClosed = false

            navController.navigate(NavigationItem.LogIn.screenRoute)
        }
    }
}