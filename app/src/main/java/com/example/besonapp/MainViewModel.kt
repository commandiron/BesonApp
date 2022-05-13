package com.example.besonapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.besonapp.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    fun setUserPassTutorialOnceFlagTrue(){
        viewModelScope.launch {
            useCases.setUserPassTutorialOnceFlag.invoke()
        }
    }
}