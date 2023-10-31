package com.example.liedetector.screens.result.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.liedetector.R
import com.example.liedetector.screens.result.ResultViewModel
import com.example.liedetector.ui.theme.TextHeading
import com.example.liedetector.ui.theme.TextNormal
import com.example.liedetector.utils.MaxWidthImage
import ir.kaaveh.sdpcompose.sdp

@Composable
fun RescanButton(modifier: Modifier = Modifier, onClick:() -> Unit) {
    Box(
        modifier = modifier.wrapContentSize().padding(20.sdp),
        contentAlignment = Alignment.Center
    ) {
        MaxWidthImage(imageId = R.mipmap.bg_text_2)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClick.invoke()
                }
                .padding(horizontal = 40.sdp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(30.sdp),
                painter = painterResource(id = R.drawable.ic_rescan),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.Rescan),
                style = TextHeading,
                textAlign = TextAlign.Center
            )
        }
    }
}