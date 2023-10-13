package com.example.liedetector.utils.commom_composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.liedetector.ui.theme.PrimaryColor
import com.example.liedetector.ui.theme.TextHeading
import ir.kaaveh.sdpcompose.sdp

@Composable
fun TopBarHome(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(PrimaryColor)
            .padding(vertical = 5.sdp, horizontal = 15.sdp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HeadingText(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(0.dp),
            textAlign = TextAlign.Left
        )
    }
}


@Composable
fun HeadingText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextHeading
    )
}
