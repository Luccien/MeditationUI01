package com.plcoding.meditationui.presentation.ui


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.plcoding.meditationui.Feature
import com.plcoding.meditationui.presentation.components.*
import com.plcoding.meditationui.presentation.theme.*






@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun HomeView(onNavigateToDetailScreen: (String) -> Unit,
             message: String?,
             scaffoldState:ScaffoldState) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column {
                    GreetingSection(message)
                    CurrentMeditation()

                    ChipSection(
                        chips = listOf(
                            "Sweet sleep",
                            "Insomnia",
                            "Depression"
                        ),
                        scaffoldState = scaffoldState,
                        onNavigateToDetailScreen = onNavigateToDetailScreen                    )

                    FeatureSection(
                        features = listOf(
                            Feature(
                                title = "Sleep meditation",
                                com.plcoding.meditationui.R.drawable.ic_headphone,
                                BlueViolet1,
                                BlueViolet2,
                                BlueViolet3
                            ),
                            Feature(
                                title = "Tips for sleeping",
                                com.plcoding.meditationui.R.drawable.ic_videocam,
                                LightGreen1,
                                LightGreen2,
                                LightGreen3
                            ),
                            Feature(
                                title = "Night island",
                                com.plcoding.meditationui.R.drawable.ic_headphone,
                                OrangeYellow1,
                                OrangeYellow2,
                                OrangeYellow3
                            ),
                            Feature(
                                title = "Calming sounds",
                                com.plcoding.meditationui.R.drawable.ic_headphone,
                                Beige1,
                                Beige2,
                                Beige3
                            )
                        )
                    )

                }

                BottomMenu(
                    items = bottomMenuItems,
                    modifier = Modifier.align(Alignment.BottomCenter),
                    onNavigateToDetailScreen = onNavigateToDetailScreen                )

            }

}










