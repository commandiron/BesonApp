package com.example.besonapp.presentation.screens.intro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.besonapp.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    fun setUserOpenAppOnceFlagTrue(){
        viewModelScope.launch {
            useCases.setUserOpenAppOnceFlagForShowSplashAndIntroScreens.invoke()
        }
    }
}