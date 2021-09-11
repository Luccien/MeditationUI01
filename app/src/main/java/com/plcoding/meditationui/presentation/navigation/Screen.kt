package com.plcoding.meditationui.presentation.navigation

sealed class Screen(
    val route: String
) {

    object HomeScreen: Screen("home_screen")

    object MusicScreen: Screen("music_screen")
}