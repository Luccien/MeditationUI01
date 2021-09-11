package com.plcoding.meditationui.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.plcoding.meditationui.presentation.ui.HomeView
import com.plcoding.meditationui.presentation.components.ToggleThemeAppBar
import com.plcoding.meditationui.presentation.theme.AppTheme

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

    val loading = viewModel.loading.value


    val scaffoldState = rememberScaffoldState()


    AppTheme(
        darkTheme = isDarkTheme,
        isNetworkAvailable =  isNetworkAvailable,
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
                    HomeView(
                        onNavigateToDetailScreen = onNavigateToDetailScreen,
                        scaffoldState = scaffoldState)
                }



    }
    }


















