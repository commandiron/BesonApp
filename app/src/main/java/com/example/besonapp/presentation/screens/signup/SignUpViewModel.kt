package com.example.besonapp.presentation.screens.signup

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.besonapp.domain.use_case.UseCases
import com.example.besonapp.util.Response
import com.example.besonapp.presentation.model.UserType
import com.example.besonapp.util.SignUpAndLogInInfoValidation
import com.example.besonapp.presentation.model.UserSignUpInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel()  {

    private val _signUpFormValidationState = mutableStateOf(SignUpAndLogInInfoValidation())
    val signUpFormValidationState : State<SignUpAndLogInInfoValidation> = _signUpFormValidationState

    private val _isUserSignUp = mutableStateOf<UserType?>(null)
    val isUserSignUp : State<UserType?> = _isUserSignUp

    fun signUp(userSignUpInfo: UserSignUpInfo, userType: UserType) {

        getSignUpFormValidationState(userSignUpInfo)

        if(!_signUpFormValidationState.value.emailError && !_signUpFormValidationState.value.passwordError){

            viewModelScope.launch {

                useCases.signUp(userSignUpInfo.email, userSignUpInfo.password).collect { response ->
                    when(response){
                        is Response.Loading -> {
                            println("Loading")
                            //Burada loading ekranı çalışacak
                        }
                        is Response.Success -> {
                            println("Success" + response.data) //Toast mesajı verebiliriz.

                            createUserProfileToFirebaseDb(userType)
                        }
                        is Response.Error -> {
                            println("Error: " + response.message) //Toast mesajı verebiliriz.
                        }
                    }
                }
            }
        }
    }

    private fun getSignUpFormValidationState(userSignUpInfo: UserSignUpInfo){
        _signUpFormValidationState.value = useCases.signUpInfoValidation.invoke(userSignUpInfo)
    }

    private fun createUserProfileToFirebaseDb(userType: UserType){

        viewModelScope.launch {

            useCases.createUserProfileToFirebaseDb.invoke(userType).collect{ response ->
                when(response){
                    is Response.Loading -> {
                        println("LoadingDb")
                    }
                    is Response.Success -> {
                        _isUserSignUp.value = userType
                        println("SuccessDb")
                    }
                    is Response.Error -> {
                        println("ErrorDb")
                    }
                }
            }
        }
    }
}
