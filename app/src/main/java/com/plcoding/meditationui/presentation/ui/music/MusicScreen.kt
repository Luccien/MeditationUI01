package com.plcoding.meditationui.presentation.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.plcoding.meditationui.presentation.components.ToggleThemeAppBar
import com.plcoding.meditationui.presentation.theme.AppTheme
import com.plcoding.meditationui.presentation.ui.home.HomeViewModel
import com.plcoding.meditationui.presentation.ui.music.MusicViewModel

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun MusicScreen(
    isDarkTheme: Boolean,
    isNetworkAvailable: Boolean,
    onToggleTheme: () -> Unit,
    viewModel: MusicViewModel
) {

    val loading = viewModel.loading.value


    val scaffoldState = rememberScaffoldState()

    AppTheme(
        darkTheme = isDarkTheme,
        isNetworkAvailable =  true,
        displayProgressBar = loading,
        scaffoldState = scaffoldState
    ){
        Scaffold(
            topBar = {
                ToggleThemeAppBar(
                    onToggleTheme = { onToggleTheme() })
            },
            scaffoldState = scaffoldState
        )
        {

            MusicView()

        }



    }
}




