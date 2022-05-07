package com.example.besonapp.presentation.screens.signup_steps

import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.besonapp.domain.model.CustomerProfile
import com.example.besonapp.domain.use_case.UseCases
import com.example.besonapp.presentation.model.UserSignUpInfo
import com.example.besonapp.presentation.model.UserType
import com.example.besonapp.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpStepsViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel()  {

    private val _isProfileUpdated = mutableStateOf(false)
    val isProfileUpdated : State<Boolean> = _isProfileUpdated

    fun createProfile(name: String, phoneNumber: String, profilePictureUri: Uri?) {

        if(profilePictureUri != null){
            uploadProfilePictureToFirebaseStorage(name, phoneNumber, profilePictureUri)
        }else{
            updateCustomerProfileToFirebaseDb(CustomerProfile(name, phoneNumber,""))
        }
    }

    private fun uploadProfilePictureToFirebaseStorage(name: String, phoneNumber: String, profilePictureUri: Uri){
        viewModelScope.launch {

            useCases.uploadProfilePictureToFirebaseStorage.invoke(profilePictureUri).collect { response ->

                when(response){
                    is Response.Loading -> {

                    }
                    is Response.Success -> {
                        updateCustomerProfileToFirebaseDb(CustomerProfile(name, phoneNumber, response.data))
                    }
                    is Response.Error -> {

                    }
                }
            }
        }
    }

    private fun updateCustomerProfileToFirebaseDb(customerProfile: CustomerProfile){
        viewModelScope.launch {
            useCases.updateCustomerProfileToFirebaseDb.invoke(customerProfile).collect{ response ->
                when(response) {
                    is Response.Loading -> {

                    }
                    is Response.Success -> {
                        _isProfileUpdated.value = response.data
                    }
                    is Response.Error -> {

                    }
                }
            }
        }
    }
}