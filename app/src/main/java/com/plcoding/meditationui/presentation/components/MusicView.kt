package com.plcoding.meditationui.presentation.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.plcoding.meditationui.R
import com.plcoding.meditationui.presentation.components.BottomMenuContent

@ExperimentalFoundationApi
@Composable
fun MusicView(onNavigateToDetailScreen: (String) -> Unit,
              scaffoldState: ScaffoldState
) {



    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()


            BottomMenu(
                items = listOf(
                    BottomMenuContent(
                        "Home",
                        R.drawable.ic_home,
                        "home_screen"
                    ),
                    BottomMenuContent(
                        "Meditate",
                        R.drawable.ic_bubble,
                        "meditation_screen"
                    ),
                    BottomMenuContent(
                        "Sleep",
                        R.drawable.ic_moon,
                        "sleep_screen"
                    ),
                    BottomMenuContent(
                        "Music",
                        R.drawable.ic_music,
                        "music_screen"
                    ),
                    BottomMenuContent(
                        "Profile",
                        R.drawable.ic_profile,
                        "profile_screen"
                    ),
                ), //modifier = Modifier.align(Alignment.BottomCenter),
                onNavigateToDetailScreen = onNavigateToDetailScreen,
            )

        }

    }
}
