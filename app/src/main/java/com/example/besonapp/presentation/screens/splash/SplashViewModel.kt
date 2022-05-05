package com.example.besonapp.presentation.screens.splash

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.besonapp.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel@Inject constructor(
    private val useCases: UseCases
): ViewModel()  {

    var isUserOpenAppOnce = mutableStateOf(false)
        private set

    init {
        getUserOpenAppOnceFlag()
    }

    fun getUserOpenAppOnceFlag(){
        viewModelScope.launch {
            useCases.getUserOpenAppOnceFlag.invoke().collect{
                isUserOpenAppOnce.value = it

            }
        }
    }
}