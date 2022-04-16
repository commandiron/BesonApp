package com.example.besonapp.presentation

import androidx.compose.runtime.Composable
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.presentation.common_components.logoanimation.LogInScreenLogoAnimationOnStart
import com.example.besonapp.presentation.floating_components.SplashScreenLogoAnimation2
import com.example.besonapp.presentation.floating_components.signup_steps.FloatingLogoWithAppName

@Composable
fun FloatingComponentsGraph(
    currentRoute: String?,
    onSignUpScreenLogoClick:() -> Unit,
    content: @Composable () -> Unit
){

    content()

    when(currentRoute){
        NavigationItem.Splash.screen_route ->{

            SplashScreenLogoAnimation2()

        }

        NavigationItem.Intro.screen_route ->{

            //IntroScreenLogoAnimation() -> Daha sonra belki eklenebilir.

        }

        NavigationItem.SignUp.screen_route -> {

            SignUpScreenLogoAnimation(){
                onSignUpScreenLogoClick()
            }

            FloatingAppExplainingStripComponent(
                isAnimated = true
            )
        }

        NavigationItem.LogIn.screen_route -> {

            LogInScreenLogoAnimationOnStart()

            FloatingLogoWithAppName()
        }

        NavigationItem.SignUpStepsAsCustomer.screen_route -> {

            LogInScreenLogoAnimationOnStart()

            FloatingLogoWithAppName()
        }

        NavigationItem.SignUpStepsAsCompany.screen_route -> {

            LogInScreenLogoAnimationOnStart()

            FloatingLogoWithAppName()
        }
    }
}