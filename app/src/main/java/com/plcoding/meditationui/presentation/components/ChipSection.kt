package com.plcoding.meditationui.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.plcoding.meditationui.presentation.theme.ButtonBlue
import com.plcoding.meditationui.presentation.theme.DarkerButtonBlue
import com.plcoding.meditationui.presentation.theme.TextWhite
import kotlinx.coroutines.launch


@Composable
fun ChipSection(
    chips: List<String>,
    scaffoldState: ScaffoldState,
    onNavigateToDetailScreen: (String) -> Unit
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    val scope = rememberCoroutineScope()

    LazyRow {
        items(chips.size) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {

                        selectedChipIndex = it
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Hello")
                        }
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)

            }

        }
    }
}
