package com.example.besonapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.besonapp.presentation.CustomAppExplainingTape
import com.example.besonapp.presentation.CustomAnimatedCustomerOrCompanyLogInContent
import com.example.besonapp.presentation.components.LogInContent
import com.example.besonapp.presentation.util.StaticTexts.APP_STATEMENT
import com.example.besonapp.presentation.util.StaticTexts.LOGIN_SCREEN_COMPANY_IMAGE_URL
import com.example.besonapp.presentation.util.StaticTexts.LOGIN_SCREEN_COMPANY_LOGIN_BUTTON_TEXT
import com.example.besonapp.presentation.util.StaticTexts.LOGIN_SCREEN_COMPANY_TEXT_BUTTON_TEXT
import com.example.besonapp.presentation.util.StaticTexts.LOGIN_SCREEN_COMPANY_TEXT_DETAILS
import com.example.besonapp.presentation.util.StaticTexts.LOGIN_SCREEN_COMPANY_TEXT_TITLE
import com.example.besonapp.presentation.util.StaticTexts.LOGIN_SCREEN_CUSTOMER_IMAGE_URL
import com.example.besonapp.presentation.util.StaticTexts.LOGIN_SCREEN_CUSTOMER_LOGIN_BUTTON_TEXT
import com.example.besonapp.presentation.util.StaticTexts.LOGIN_SCREEN_CUSTOMER_TEXT_BUTTON_TEXT
import com.example.besonapp.presentation.util.StaticTexts.LOGIN_SCREEN_CUSTOMER_TEXT_DETAILS
import com.example.besonapp.presentation.util.StaticTexts.LOGIN_SCREEN_CUSTOMER_TEXT_TITLE
import com.example.besonapp.ui.theme.logoBackground
import com.example.besonapp.ui.theme.selectCustomerOrCompanyScreenColor1
import com.example.besonapp.ui.theme.selectCustomerOrCompanyScreenColor2

@Composable
fun LogInScreen(
    navController: NavController,
    isLogoClicked: Boolean) {

    var customerCloseLoginWindow by remember { mutableStateOf(false)}
    var companyCloseLoginWindow by remember { mutableStateOf(false)}

    LaunchedEffect(key1 = isLogoClicked){
        customerCloseLoginWindow = !customerCloseLoginWindow
        companyCloseLoginWindow = !companyCloseLoginWindow
    }

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        val constraints = this.constraints

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.TopCenter) {

                Surface(
                    color = logoBackground
                ) {

                    LogInContent(LOGIN_SCREEN_CUSTOMER_LOGIN_BUTTON_TEXT){
                        //Müşteri olarak giriş yaptır ya da kayıt oldur.
                    }

                    CustomAnimatedCustomerOrCompanyLogInContent(
                        title = LOGIN_SCREEN_CUSTOMER_TEXT_TITLE,
                        details = LOGIN_SCREEN_CUSTOMER_TEXT_DETAILS,
                        button = LOGIN_SCREEN_CUSTOMER_TEXT_BUTTON_TEXT,
                        imageUrl = LOGIN_SCREEN_CUSTOMER_IMAGE_URL,
                        surfaceColor = selectCustomerOrCompanyScreenColor1,
                        targetOffsetValue = -constraints.maxHeight/4.toFloat() + 130f,
                        closeLoginWindow = customerCloseLoginWindow
                    ){
                        companyCloseLoginWindow = !companyCloseLoginWindow
                    }
                }
            }


            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.BottomCenter) {

                Surface(
                    color = logoBackground
                ) {

                    LogInContent(LOGIN_SCREEN_COMPANY_LOGIN_BUTTON_TEXT){
                        //Firma olarak giriş yaptır ya da kayıt oldur.
                    }

                    CustomAnimatedCustomerOrCompanyLogInContent(
                        title = LOGIN_SCREEN_COMPANY_TEXT_TITLE,
                        details = LOGIN_SCREEN_COMPANY_TEXT_DETAILS,
                        button = LOGIN_SCREEN_COMPANY_TEXT_BUTTON_TEXT,
                        imageUrl = LOGIN_SCREEN_COMPANY_IMAGE_URL,
                        surfaceColor = selectCustomerOrCompanyScreenColor2,
                        targetOffsetValue = constraints.maxHeight/4.toFloat() -130f,
                        closeLoginWindow = companyCloseLoginWindow
                    ){
                        customerCloseLoginWindow = !customerCloseLoginWindow
                    }
                }

                Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter) {
                    CustomAppExplainingTape(APP_STATEMENT)
                }
            }
        }
    }
}