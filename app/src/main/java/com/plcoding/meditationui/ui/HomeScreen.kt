package com.plcoding.meditationui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import com.plcoding.meditationui.ui.HomeView
import com.plcoding.meditationui.ui.HomeViewModel
import com.plcoding.meditationui.ui.theme.AppTheme

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
        darkTheme = true,
        isNetworkAvailable =  true,
        displayProgressBar = false,
        scaffoldState = scaffoldState
    ){
        Scaffold(
            /*topBar = {
                ToggelThemeBar()
                },*/
                scaffoldState = scaffoldState
        )
                {
                    HomeView(
                        onNavigateToDetailScreen = onNavigateToDetailScreen,
                        scaffoldState = scaffoldState)
                }



    }
    }


















