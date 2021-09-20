package com.plcoding.meditationui.presentation.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.plcoding.meditationui.presentation.components.bottomMenuItems

@ExperimentalFoundationApi
@Composable
fun MusicView(onNavigateToDetailScreen: (String) -> Unit,
              message: String?,
              scaffoldState: ScaffoldState

) {


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            GreetingSection(caption = message)

            BottomMenu(
                items = bottomMenuItems,
                //modifier = Modifier.align(Alignment.BottomCenter),
                onNavigateToDetailScreen = onNavigateToDetailScreen,
                initialSelectedItemIndex = 3

            )

        }

    }
}
