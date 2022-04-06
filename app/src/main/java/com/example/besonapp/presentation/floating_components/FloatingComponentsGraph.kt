package com.example.besonapp.presentation

import androidx.compose.runtime.Composable
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.presentation.common_components.logoanimation.LogInScreenLogoAnimationOnStart
import com.example.besonapp.presentation.floating_components.intro.IntroScreenLogoAnimation

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

            FloatingAppExplainingTapeComponent()

        }

        NavigationItem.Intro.screenRoute ->{

            //IntroScreenLogoAnimation()

        }

        NavigationItem.SignUp.screenRoute -> {

            SignUpScreenLogoAnimation(){
                onSignUpScreenLogoClick()
            }

            FloatingAppExplainingTapeComponent()

        }
        NavigationItem.LogIn.screenRoute -> {

            LogInScreenLogoAnimationOnStart()

        }
    }
}