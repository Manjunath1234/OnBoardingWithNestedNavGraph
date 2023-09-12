package com.example.onboardingwithnewsplashapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onboardingwithnewsplashapi.data.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
   private val repository: DataStoreRepository
):ViewModel(){

    fun saveOnBoardingState(completed:Boolean){
        viewModelScope.launch {
            repository.saveOnBoardingState(completed)
        }
    }
}