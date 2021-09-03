package com.plcoding.meditationui.presentation.ui.music

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MusicViewModel
    @Inject
    constructor()
            : ViewModel() {


        val loading = mutableStateOf(false)



    }
