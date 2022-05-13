package com.example.besonapp.presentation.screens.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.besonapp.domain.use_case.UseCases
import com.example.besonapp.presentation.model.UserLogInInfo
import com.example.besonapp.util.Response
import com.example.besonapp.util.SignUpAndLogInInfoValidation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _logInFormValidationState = mutableStateOf(SignUpAndLogInInfoValidation())
    val logInFormValidationState : State<SignUpAndLogInInfoValidation> = _logInFormValidationState

    private val _isUserLogIn = mutableStateOf(false)
    val isUserLogIn : State<Boolean> = _isUserLogIn

    fun logIn(userLogInInfo: UserLogInInfo) {
        getLogInFormValidationState(userLogInInfo)
        if(!_logInFormValidationState.value.emailError && !_logInFormValidationState.value.passwordError){
            viewModelScope.launch {
                useCases.logIn(userLogInInfo.email, userLogInInfo.password).collect { response ->
                    when(response){
                        is Response.Loading -> {
                            println("Loading")
                            //Burada loading ekranı çalışacak
                        }
                        is Response.Success -> {
                            println("Success" + response.data) //Toast mesajı verebiliriz.
                            _isUserLogIn.value = response.data
                        }
                        is Response.Error -> {
                            println("Error: " + response.message) //Toast mesajı verebiliriz.
                        }
                    }
                }
            }
        }
    }

    private fun getLogInFormValidationState(userLogInInfo: UserLogInInfo){
        _logInFormValidationState.value = useCases.logInInfoValidation.invoke(userLogInInfo)
    }
}