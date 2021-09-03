package com.plcoding.meditationui.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.plcoding.meditationui.R




private val QuickSand = FontFamily(
    Font(R.font.quicksand_light, FontWeight.W300),
    Font(R.font.quicksand_regular, FontWeight.W400),
    Font(R.font.quicksand_medium, FontWeight.W500),
    Font(R.font.quicksand_bold, FontWeight.W600)
)

val QuickSandTypography = Typography(
    h1 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W500,
        fontSize = 30.sp,
    ),
    h2 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp,
    ),
    h3 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp,
    ),
    h4 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp,
    ),
    h5 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
    ),
    h6 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
    ),
    subtitle2 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = QuickSand,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 15.sp,
        color = Color.White
    ),
    caption = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )
)












/////////////////////////////////////////////////////  /// TODO delete old code ////////////
val gothicA1 = FontFamily(
    listOf(
        Font(R.font.gothica1_regular, FontWeight.Normal),
        Font(R.font.gothica1_medium, FontWeight.Medium),
        Font(R.font.gothica1_semibold, FontWeight.SemiBold),
        Font(R.font.gothica1_bold, FontWeight.Bold),
        Font(R.font.gothica1_black, FontWeight.Black),
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        color = AquaBlue,
        fontFamily = gothicA1,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    h1 = TextStyle(
        color = TextWhite,
        fontFamily = gothicA1,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    h2 = TextStyle(
        color = TextWhite,
        fontFamily = gothicA1,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
)
/////////////////////////////////////////////////  OLD  ////////////






/*
val Roboto = FontFamily(
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_bold, FontWeight.Bold),
)

val RobotoCondensed = FontFamily(
    Font(R.font.roboto_condensed_light, FontWeight.Light),
    Font(R.font.roboto_condensed_regular, FontWeight.Normal),
)

*/

 /*
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    */

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
//)