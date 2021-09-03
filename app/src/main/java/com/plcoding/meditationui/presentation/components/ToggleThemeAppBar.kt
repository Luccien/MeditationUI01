package com.plcoding.meditationui.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout


@ExperimentalComposeUiApi
@Composable
fun ToggleThemeAppBar(onToggleTheme: () -> Unit){
    Column{
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            ConstraintLayout(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                val (menu) = createRefs()
                IconButton(
                    modifier = Modifier
                        .constrainAs(menu) {
                            end.linkTo(parent.end)
                            linkTo(top = parent.top, bottom = parent.bottom)
                        },
                    onClick = onToggleTheme,
                ) {
                    Icon(Icons.Filled.MoreVert, contentDescription = "Toggle Dark/Light Theme")
                }
            }// end ConstraintLayout


        }// end row

    }// end column

}