package com.example.besonapp

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.besonapp.presentation.CustomAppExplainingTape
import com.example.besonapp.presentation.CustomAppLogoIcon
import com.example.besonapp.presentation.util.StaticTexts.APP_NAME
import com.example.besonapp.presentation.util.StaticTexts.APP_STATEMENT
import com.example.besonapp.ui.theme.selectCustomerOrCompanyScreenColor1
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    var startAnimationAlpha by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimationAlpha) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2000
        )
    )

    var startAnimationRotate by remember { mutableStateOf(false) }
    val rotateAnim = animateFloatAsState(
        targetValue = if (startAnimationRotate){
            360f
        } else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    LaunchedEffect(Unit) {

        delay(1600)

        startAnimationAlpha = true

        delay(2000)

        startAnimationRotate = true

        delay(1000)

        navController.popBackStack()
        navController.navigate(NavigationItem.SelectCustomerOrCompany.screenRoute)
    }

    Splash(alpha = alphaAnim.value, rotate = rotateAnim.value)
}

@Composable
fun Splash(
    alpha: Float,
    rotate: Float) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Surface(
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colors.background
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CustomAppLogoIcon(alphaAnimValue = alpha, rotateAnimValue = rotate)

                Text(
                    text = APP_NAME,
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier
                        .alpha(alpha = alpha)
                        .padding(top = 160.dp)
                )
            }
        }

        Surface(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
            color = selectCustomerOrCompanyScreenColor1
        ) {
            CustomAppExplainingTape(APP_STATEMENT)
        }
    }

}
