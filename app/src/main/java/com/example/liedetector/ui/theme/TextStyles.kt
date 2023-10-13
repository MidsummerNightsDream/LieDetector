package com.example.liedetector.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.liedetector.R
import ir.kaaveh.sdpcompose.ssp

val obiFont = FontFamily(
    Font(R.font.obi_font, FontWeight.Normal),
)

val TextNormal: TextStyle
    @Composable get() =
        TextStyle(
            fontFamily = obiFont,
            fontWeight = FontWeight.Normal,
            fontSize = 12.ssp,
            color = Color.Black
        )

val TextHeading: TextStyle
    @Composable get() =
        TextStyle(
            fontFamily = obiFont,
            fontWeight = FontWeight.Bold,
            fontSize = 14.ssp,
            color = Color.Black
        )