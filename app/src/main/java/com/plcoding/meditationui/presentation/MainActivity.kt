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
import com.plcoding.meditationui.presentation.navigation.Screen
import com.plcoding.meditationui.presentation.ui.music.MusicViewModel
import com.plcoding.meditationui.presentation.util.ConnectivityManager
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var connectivityManager: ConnectivityManager


    @Inject
    lateinit var settingsDataStore: SettingsDataStore

    override fun onStart() {
        super.onStart()
        connectivityManager.registerConnectionObserver(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        connectivityManager.unregisterConnectionObserver(this)
    }


    @ExperimentalFoundationApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.HomeScreen.route
                ) {
                    composable(Screen.HomeScreen.route ) {navBackStackEntry ->
                        val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                        val viewModel: HomeViewModel = viewModel("HomeViewModel", factory)

                        HomeScreen(
                            isDarkTheme = settingsDataStore.isDark.value,
                            isNetworkAvailable = connectivityManager.isNetworkAvailable.value,
                            onToggleTheme = settingsDataStore::toggleTheme,
                            onNavigateToDetailScreen = navController::navigate,
                            viewModel = viewModel
                        )
                    }
                    composable(Screen.MusicScreen.route + "/{message}",
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
                            isNetworkAvailable = connectivityManager.isNetworkAvailable.value,
                            onToggleTheme = settingsDataStore::toggleTheme,
                            onNavigateToDetailScreen = navController::navigate,
                                message = navBackStackEntry.arguments?.getString("message"),//navBackStackEntry.arguments?.getString("message"),
                                viewModel = viewModel)
                        }


                }

        }
    }




}
