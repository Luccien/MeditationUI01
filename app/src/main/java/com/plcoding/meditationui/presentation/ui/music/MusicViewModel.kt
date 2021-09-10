package com.plcoding.meditationui.presentation.ui.music

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.meditationui.domain.model.Music
import com.plcoding.meditationui.interactors.GetMusic
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MusicViewModel
    @Inject
    constructor(
        private val getMusic: GetMusic,
    ): ViewModel() {

        val loading = mutableStateOf(false)
        val music: MutableState<Music?> = mutableStateOf(null)


///////////////////////////
fun getMusic(){
    getMusic.execute().onEach { dataState ->
        //loading.value = dataState.loading

        dataState?.let { data ->
            music.value = data

        }

        /*
        dataState.error?.let { error ->
            Log.e(TAG, "getRecipe: ${error}")
            dialogQueue.appendErrorMessage("An Error Occurred", error)
        }*/
    }.launchIn(viewModelScope)
}
///////////////////////


    }
