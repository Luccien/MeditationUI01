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
    onNavigateToDetailScreen: (String) -> Unit,
    message: String?,
    viewModel: MusicViewModel
) {

    val loading = viewModel.loading.value
    val music = viewModel.music.value

    val scaffoldState = rememberScaffoldState()

    //viewModel.onTriggerEvent(RecipeEvent.GetRecipeEvent(recipeId)) // TODO  onTriggerEvent
    viewModel.getMusic()

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

            if(music != null) {
                music?.let { MusicView(
                    onNavigateToDetailScreen = onNavigateToDetailScreen,
                    message = it.title,
                    scaffoldState = scaffoldState
                )
                }
            }




        }



    }
}



