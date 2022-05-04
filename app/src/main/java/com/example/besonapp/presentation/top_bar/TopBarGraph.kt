package com.example.besonapp.presentation.top_bar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.besonapp.presentation.navigation.NavigationItem
import com.example.besonapp.presentation.topbar.TopBarView

@Composable
fun TopBarGraph(
    currentRoute: String?,
    content: @Composable () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter) {

        content()

        when(currentRoute){

            NavigationItem.Profile.screen_route ->{
                TopBarView(title = NavigationItem.Profile.title)
            }

            NavigationItem.Prices.screen_route ->{
                TopBarView(title = NavigationItem.Prices.title)
            }

            NavigationItem.PostPrice.screen_route ->{
                TopBarView(title = "")
            }


        }
    }
}