package com.example.liedetector.screens.finger_print.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.liedetector.R
import com.example.liedetector.ui.theme.TextNormal
import com.example.liedetector.utils.MaxWidthImage

@Composable
fun HoldButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.wrapContentSize(),
        contentAlignment = Alignment.Center
    ) {
        MaxWidthImage(imageId = R.mipmap.bg_text)
        Text(
            text = stringResource(id = R.string.Hold_To_Scan),
            style = TextNormal
        )
    }
}