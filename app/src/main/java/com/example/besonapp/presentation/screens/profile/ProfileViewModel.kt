package com.example.besonapp.presentation.screens.profile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.besonapp.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel@Inject constructor(
    private val useCases: UseCases
): ViewModel()  {

    var isUserPassTutorialOnce = mutableStateOf<Boolean?>(null)
        private set

    init {
        getUserPassTutorialOnceFlag()
    }

    fun getUserPassTutorialOnceFlag(){
        viewModelScope.launch {
            useCases.getUserPassTutorialOnceFlag.invoke().collect{
                isUserPassTutorialOnce.value = it
            }
        }
    }
}
