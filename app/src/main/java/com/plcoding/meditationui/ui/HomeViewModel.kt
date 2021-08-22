package com.plcoding.meditationui.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel: ViewModel() {


    val loading = mutableStateOf(false)

    fun loadTest(){
        viewModelScope.launch {

        }
    }

}