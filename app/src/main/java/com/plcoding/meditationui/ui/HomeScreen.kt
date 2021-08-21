package com.plcoding.meditationui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import com.plcoding.meditationui.ui.HomeView

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun HomeScreen(
    navController: NavController,
) {

        HomeView(navController = navController)

    }


















