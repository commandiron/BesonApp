package com.example.besonapp.presentation

import androidx.compose.runtime.Composable
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.presentation.common_components.logoanimation.LogInScreenLogoAnimationOnStart

@Composable
fun FloatingComponentsGraph(
    currentRoute: String?,
    onSignUpScreenLogoClick:() -> Unit,
    content: @Composable () -> Unit
){

    content()

    when(currentRoute){
        NavigationItem.Splash.screenRoute ->{

            SplashScreenLogoAnimation()

        }

        NavigationItem.Intro.screenRoute ->{

            //IntroScreenLogoAnimation() -> Daha sonra belki eklenebilir.

        }

        NavigationItem.SignUp.screenRoute -> {

            SignUpScreenLogoAnimation(){
                onSignUpScreenLogoClick()
            }

            FloatingAppExplainingStripComponent(
                isAnimated = true
            )
        }

        NavigationItem.LogIn.screenRoute -> {
            LogInScreenLogoAnimationOnStart()
        }
    }
}