package com.plcoding.meditationui.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.dp
import com.plcoding.meditationui.presentation.components.IMAGE_HEIGHT
import com.plcoding.meditationui.presentation.components.LoadingShimmer
import com.plcoding.meditationui.presentation.ui.HomeView
import com.plcoding.meditationui.presentation.components.ToggleThemeAppBar
import com.plcoding.meditationui.presentation.theme.AppTheme
import com.plcoding.meditationui.presentation.ui.MusicView
import com.plcoding.meditationui.presentation.ui.music.MusicEvent

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun HomeScreen(
    isDarkTheme: Boolean,
    isNetworkAvailable: Boolean,
    onToggleTheme: () -> Unit,
    onNavigateToDetailScreen: (String) -> Unit,
    viewModel: HomeViewModel
) {

    val home = viewModel.home.value
    // fire a one-off event to get the music from api
    val onLoad = viewModel.onLoad.value
    if (!onLoad) {
        viewModel.onLoad.value = true
        viewModel.onTriggerEvent(HomeEvent.GetHomeEvent)
    }

    val loading = viewModel.loading.value
    val dialogQueue = viewModel.dialogQueue

    val scaffoldState = rememberScaffoldState()


    AppTheme(
        darkTheme = isDarkTheme,
        isNetworkAvailable =  isNetworkAvailable,
        displayProgressBar = loading,
        scaffoldState = scaffoldState,
        dialogQueue = dialogQueue.queue.value,
    ){
        Scaffold(
            topBar = {
                ToggleThemeAppBar(
                    onToggleTheme = { onToggleTheme() })
                },
                scaffoldState = scaffoldState
        )
                {


                    if (loading && home == null) {
                        LoadingShimmer(imageHeight = IMAGE_HEIGHT.dp)
                    }
                    else if(!loading && home == null && onLoad){
                        TODO("Show Invalid ")
                    }
                    else {
                        home?.let {
                            HomeView(
                                onNavigateToDetailScreen = onNavigateToDetailScreen,
                                message = it.title,
                                scaffoldState = scaffoldState
                            )
                        }
                    }


                }



    }
    }


















