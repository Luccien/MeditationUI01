package com.plcoding.meditationui.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import com.plcoding.meditationui.ui.components.ToggleThemeAppBar
import com.plcoding.meditationui.ui.theme.AppTheme

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun DetailScreen(
    isDarkTheme: Boolean,
    isNetworkAvailable: Boolean,
    onToggleTheme: () -> Unit,
    viewModel: HomeViewModel
) {

// TODO -- another viewmodel for DetailScreen -- othervise loading will be same for both
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

            DetailView()

        }



    }
}




