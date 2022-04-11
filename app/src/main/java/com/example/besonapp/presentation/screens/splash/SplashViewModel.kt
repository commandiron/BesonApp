package com.example.besonapp.presentation.screens.splash

//@HiltViewModel
//class SplashViewModel@Inject constructor(
//    private val useCases: UseCases
//): ViewModel()  {
//
//    var isUserOpenAppOnce = mutableStateOf(false)
//        private set
//
//    init {
//        getUserOpenAppOnceFlag()
//    }
//
//    fun getUserOpenAppOnceFlag(){
//        viewModelScope.launch {
//            useCases.getUserOpenAppOnceFlag.invoke().collect{
//                isUserOpenAppOnce.value = it
//
//            }
//        }
//    }
//}