package com.plcoding.meditationui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.meditationui.ui.DetailScreen
import com.plcoding.meditationui.ui.HomeViewModel
import com.plcoding.meditationui.ui.theme.JetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.compose.*


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home_screen"
                ) {
                    composable("home_screen") {navBackStackEntry ->
                        val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                        val viewModel: HomeViewModel = viewModel("HomeViewModel", factory)


                        HomeScreen(
                            isDarkTheme = false,
                            isNetworkAvailable = true,
                            onToggleTheme = { } ,
                            onNavigateToDetailScreen = navController::navigate,
                            viewModel = viewModel

                        )

                    }
                    composable("detail_screen") {
                        DetailScreen(navController = navController)

                    }

                    /*
                    composable(
                        "pokemon_detail_screen/{dominantColor}/{name}",
                        arguments = listOf(
                            navArgument("dominantColor") {
                                type = NavType.IntType
                            },
                            navArgument("name") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val dominantColor = remember {
                            val color = it.arguments?.getInt("dominantColor")
                            color?.let { Color(it) } ?: Color.White
                        }
                        val name = remember {
                            it.arguments?.getString("name")
                        }

                    }*/
                }
            }
        }
    }
}
