package com.example.myeducationalprojectdota.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myeducationalprojectdota.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    // Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
        fontWeight = FontWeight(700),
        letterSpacing = 0.6.sp
    ),
    titleSmall = TextStyle(
        lineHeight = 19.sp,
        fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
        fontWeight = FontWeight(400)
    ),

    labelSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
        fontWeight = FontWeight(500)
    )
)