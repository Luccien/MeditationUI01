package com.plcoding.meditationui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.meditationui.presentation.ui.MusicScreen
import com.plcoding.meditationui.presentation.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.compose.*
import com.plcoding.meditationui.presentation.ui.home.HomeScreen
import com.plcoding.meditationui.datastore.SettingsDataStore
import com.plcoding.meditationui.presentation.ui.music.MusicViewModel
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var settingsDataStore: SettingsDataStore

    @ExperimentalFoundationApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home_screen"
                ) {
                    composable("home_screen") {navBackStackEntry ->
                        val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                        val viewModel: HomeViewModel = viewModel("HomeViewModel", factory)

                        HomeScreen(
                            isDarkTheme = settingsDataStore.isDark.value,
                            isNetworkAvailable = true,
                            onToggleTheme = settingsDataStore::toggleTheme,
                            onNavigateToDetailScreen = navController::navigate,
                            viewModel = viewModel
                        )
                    }
                    composable("music_screen/{message}",
                            arguments = listOf(
                            navArgument("message") {
                                type = NavType.StringType
                            }
                            ) )
                            {navBackStackEntry ->

                                val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                                 val viewModel: MusicViewModel = viewModel("MusicViewModel", factory)

                            MusicScreen(
                            isDarkTheme = settingsDataStore.isDark.value,
                            isNetworkAvailable = true,
                            onToggleTheme = settingsDataStore::toggleTheme,
                            onNavigateToDetailScreen = navController::navigate,
                                message = navBackStackEntry.arguments?.getString("message"),//navBackStackEntry.arguments?.getString("message"),
                                viewModel = viewModel)
                        }


                }

        }
    }




}
