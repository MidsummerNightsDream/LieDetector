package com.example.liedetector.screens.finger_print.composables

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.liedetector.R
import com.example.liedetector.ui.theme.GradientEndColor
import com.example.liedetector.ui.theme.GradientStartColor
import ir.kaaveh.sdpcompose.sdp

@Composable
fun Lights(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 4.dp,
                brush = Brush.verticalGradient(
                    colors = listOf(GradientStartColor, GradientEndColor)
                ),
                shape = RoundedCornerShape(size = 5.sdp)
            )
            .padding(10.sdp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Image(painter = painterResource(id = R.drawable.img_red_light), contentDescription = null)
        Image(painter = painterResource(id = R.drawable.img_green_light), contentDescription = null)
    }
}