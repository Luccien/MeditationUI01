package com.plcoding.meditationui.presentation.ui.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.meditationui.domain.model.Home
import com.plcoding.meditationui.domain.model.Music
import com.plcoding.meditationui.interactors.GetHome
import com.plcoding.meditationui.interactors.GetMusic
import com.plcoding.meditationui.presentation.ui.music.MusicEvent
import com.plcoding.meditationui.presentation.util.ConnectivityManager
import com.plcoding.meditationui.util.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val getHome: GetHome,
    private val connectivityManager: ConnectivityManager
)
    : ViewModel() {

    val onLoad: MutableState<Boolean> = mutableStateOf(false)

    val loading = mutableStateOf(false)
    val home: MutableState<Home?> = mutableStateOf(null)



    fun onTriggerEvent(event: HomeEvent){
        viewModelScope.launch {
            try {
                when(event){
                    is HomeEvent.GetHomeEvent -> {
                        if(home.value == null){
                           getHome()
                        }
                    }
                }
            }catch (e: Exception){
                Log.e(TAG, "launchJob: Exception: ${e}, ${e.cause}")
                e.printStackTrace()
            }
        }
    }



    fun getHome(){
        getHome.execute( connectivityManager.isNetworkAvailable.value).onEach { dataState ->
            loading.value = dataState.loading

            dataState.data?.let { data ->
                home.value = data
            }

            dataState.error?.let { error ->
                Log.e(TAG, "getHome: ${error}")
                //dialogQueue.appendErrorMessage("An Error Occurred", error) TODO
            }

        }.launchIn(viewModelScope)
    }



}