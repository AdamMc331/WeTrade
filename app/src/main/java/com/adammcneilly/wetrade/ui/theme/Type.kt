package com.adammcneilly.wetrade.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.adammcneilly.wetrade.R

private val MontserratExtraBold = FontFamily(Font(R.font.montserrat_extrabold))
private val MontserratSemiBold = FontFamily(Font(R.font.montserrat_semibold))
private val MontserratMedium = FontFamily(Font(R.font.montserrat_medium))
private val MontserratLight = FontFamily(Font(R.font.montserrat_light))
private val MontserratBold = FontFamily(Font(R.font.montserrat_bold))

// Set of Material typography styles to start with
val typography = Typography(
    h1 = TextStyle(
        fontFamily = MontserratExtraBold,
        fontSize = 40.sp,
        letterSpacing = 1.25.sp,
    ),
    h2 = TextStyle(
        fontFamily = MontserratExtraBold,
        fontSize = 36.sp,
    ),
    h3 = TextStyle(
        fontFamily = MontserratSemiBold,
        fontSize = 13.sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = MontserratMedium,
        fontSize = 15.sp,
    ),
    body1 = TextStyle(
        fontFamily = MontserratLight,
        fontSize = 13.sp,
    ),
    button = TextStyle(
        fontFamily = MontserratBold,
        fontSize = 13.sp,
        letterSpacing = 1.25.sp,
    )
)