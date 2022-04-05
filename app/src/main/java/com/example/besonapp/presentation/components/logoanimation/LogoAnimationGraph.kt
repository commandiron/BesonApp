package com.example.besonapp.presentation

import androidx.compose.runtime.Composable
import com.example.besonapp.NavigationItem
import com.example.besonapp.presentation.components.logoanimation.LogInLogoAnimation

@Composable
fun LogoAnimationGraph(
    currentRoute: String?,
    onLogoClick:() -> Unit,
    content: @Composable () -> Unit
){

    content()

    when(currentRoute){
        NavigationItem.Splash.screenRoute ->{
            SplashLogoAnimation()
        }
        NavigationItem.Login.screenRoute -> {
            CustomerOrCompanyLogoAnimation(){
                onLogoClick()
            }
        }
        NavigationItem.Profile.screenRoute -> {
            LogInLogoAnimation()
        }
    }
}