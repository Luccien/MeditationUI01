package com.plcoding.meditationui.presentation.ui.music

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.meditationui.domain.model.Music
import com.plcoding.meditationui.interactors.GetMusic
import com.plcoding.meditationui.presentation.util.ConnectivityManager
import com.plcoding.meditationui.util.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicViewModel
    @Inject
    constructor(
        private val getMusic: GetMusic,
        private val connectivityManager: ConnectivityManager
    ): ViewModel() {

    val onLoad: MutableState<Boolean> = mutableStateOf(false)

    val loading = mutableStateOf(false)
        val music: MutableState<Music?> = mutableStateOf(null)



    fun onTriggerEvent(event: MusicEvent){
        viewModelScope.launch {
            try {
                when(event){
                    is MusicEvent.GetMusicEvent -> {
                        if(music.value == null){
                            getMusic()
                        }
                    }
                }
            }catch (e: Exception){
                Log.e(TAG, "launchJob: Exception: ${e}, ${e.cause}")
                e.printStackTrace()
            }
        }
    }



///////////////////////////
fun getMusic(){
    getMusic.execute( connectivityManager.isNetworkAvailable.value).onEach { dataState ->
        loading.value = dataState.loading

        dataState.data?.let { data ->
            music.value = data
        }

        dataState.error?.let { error ->
            Log.e(TAG, "getMusic: ${error}")
            //dialogQueue.appendErrorMessage("An Error Occurred", error) TODO
        }

    }.launchIn(viewModelScope)
}
///////////////////////


    }
