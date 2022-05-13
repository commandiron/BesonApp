package com.example.besonapp.presentation.screens.signup_steps

import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.besonapp.domain.model.CompanyProfile
import com.example.besonapp.domain.model.CustomerProfile
import com.example.besonapp.domain.use_case.UseCases
import com.example.besonapp.presentation.model.MainConstructionItem
import com.example.besonapp.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpStepsViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel()  {

    private val _isCustomerProfileUpdated = mutableStateOf(false)
    val isCustomerProfileUpdated : State<Boolean> = _isCustomerProfileUpdated

    private val _isCompanyProfileUpdated = mutableStateOf(false)
    val isCompanyProfileUpdated : State<Boolean> = _isCompanyProfileUpdated

    private val _mainConstructionCategoriesState = mutableStateOf<List<MainConstructionItem>>(listOf())
    val mainConstructionCategoriesState : State<List<MainConstructionItem>> = _mainConstructionCategoriesState

    init {
        createMainConstructionCategories()
    }

    fun createCustomerProfile(name: String, phoneNumber: String, profilePictureUri: Uri?) {
        if(profilePictureUri != null){
            uploadCustomerProfilePictureToFirebaseStorage(name, phoneNumber, profilePictureUri)
        }else{
            updateCustomerProfileToFirebaseDb(CustomerProfile(name, phoneNumber,""))
        }
    }

    private fun uploadCustomerProfilePictureToFirebaseStorage(name: String, phoneNumber: String, profilePictureUri: Uri){
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
                        _isCustomerProfileUpdated.value = response.data
                    }
                    is Response.Error -> {
                    }
                }
            }
        }
    }

    fun createCompanyProfile(name: String, phoneNumber: String, profilePictureUri: Uri?, mainConstructionItemId: Int, subConstructionItemIdList: List<Int>) {
        if(profilePictureUri != null){
            uploadCompanyProfilePictureToFirebaseStorage(name, phoneNumber, profilePictureUri, mainConstructionItemId, subConstructionItemIdList)
        }else{
            updateCompanyProfileToFirebaseDb(CompanyProfile(name, phoneNumber,"", mainConstructionItemId, subConstructionItemIdList))
        }
    }

    private fun uploadCompanyProfilePictureToFirebaseStorage(name: String, phoneNumber: String, profilePictureUri: Uri, mainConstructionItemId: Int, subConstructionItemIdList: List<Int>){
        viewModelScope.launch {
            useCases.uploadProfilePictureToFirebaseStorage.invoke(profilePictureUri).collect { response ->
                when(response){
                    is Response.Loading -> {

                    }
                    is Response.Success -> {
                        updateCompanyProfileToFirebaseDb(CompanyProfile(name, phoneNumber, response.data, mainConstructionItemId, subConstructionItemIdList))
                    }
                    is Response.Error -> {

                    }
                }
            }
        }
    }

    private fun updateCompanyProfileToFirebaseDb(companyProfile: CompanyProfile) {
        viewModelScope.launch {
            useCases.updateCompanyProfileToFirebaseDb.invoke(companyProfile).collect{ response ->
                when(response) {
                    is Response.Loading -> {

                    }
                    is Response.Success -> {
                        _isCompanyProfileUpdated.value = response.data
                    }
                    is Response.Error -> {
                        println(response.message)
                    }
                }
            }
        }
    }

    fun createMainConstructionCategories(){
        _mainConstructionCategoriesState.value = useCases.createMainConstructionCategories.invoke()
    }
}