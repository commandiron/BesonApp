package com.example.besonapp.presentation.screens.signup_steps

import androidx.lifecycle.ViewModel
import com.example.besonapp.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpStepsViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel()  {

}