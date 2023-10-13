package com.example.liedetector.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.liedetector.R

@Composable
fun ImageBackgroundBox(
    modifier: Modifier = Modifier,
    bgImage: Int,
    contentScale: ContentScale = ContentScale.FillHeight,
    content: @Composable (Modifier) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Transparent)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = bgImage),
            contentDescription = null,
            contentScale = contentScale
        )
        content(Modifier.fillMaxSize())
    }
}

@Composable
fun ImageBackgroundColumn(
    modifier: Modifier = Modifier,
    content: @Composable (Modifier) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Transparent)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.mipmap.bg),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            content(Modifier.fillMaxSize())
        }
    }
}
