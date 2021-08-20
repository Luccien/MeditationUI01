package com.plcoding.meditationui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.meditationui.ui.DetailScreen
import com.plcoding.meditationui.ui.theme.JetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

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
                    //startDestination = "detail_screen"
                ) {
                    composable("home_screen") {
                        HomeScreen(navController = navController)

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
