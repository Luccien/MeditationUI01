package com.plcoding.meditationui.presentation.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.dp
import com.plcoding.meditationui.presentation.components.IMAGE_HEIGHT
import com.plcoding.meditationui.presentation.components.LoadingShimmer
import com.plcoding.meditationui.presentation.components.ToggleThemeAppBar
import com.plcoding.meditationui.presentation.theme.AppTheme
import com.plcoding.meditationui.presentation.ui.music.MusicEvent
import com.plcoding.meditationui.presentation.ui.music.MusicViewModel

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun MusicScreen(
    isDarkTheme: Boolean,
    isNetworkAvailable: Boolean,
    onToggleTheme: () -> Unit,
    onNavigateToDetailScreen: (String) -> Unit,
    message: String?,
    viewModel: MusicViewModel
) {


        // fire a one-off event to get the music from api
        val onLoad = viewModel.onLoad.value
        if (!onLoad) {
            viewModel.onLoad.value = true
            viewModel.onTriggerEvent(MusicEvent.GetMusicEvent)
        }


        val loading = viewModel.loading.value
        val music = viewModel.music.value
        val dialogQueue = viewModel.dialogQueue
        val scaffoldState = rememberScaffoldState()


        AppTheme(
            darkTheme = isDarkTheme,
            isNetworkAvailable = isNetworkAvailable,
            displayProgressBar = loading,
            scaffoldState = scaffoldState,
            dialogQueue = dialogQueue.queue.value,
        ) {
            Scaffold(
                topBar = {
                    ToggleThemeAppBar(
                        onToggleTheme = { onToggleTheme() })
                },
                scaffoldState = scaffoldState
            )
            {


                if (loading && music == null) {
                    LoadingShimmer(imageHeight = IMAGE_HEIGHT.dp)
                }
                else if(!loading && music == null && onLoad){
                    TODO("Show Invalid ")
                }
                else {
                    music?.let {
                        MusicView(
                            onNavigateToDetailScreen = onNavigateToDetailScreen,
                            message = message + " " + it.title,
                            scaffoldState = scaffoldState
                        )
                    }
                }


            }


        }

}



