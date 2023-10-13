package com.example.liedetector.screens.splash

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.liedetector.R
import com.example.liedetector.navigation.NavigationScreens
import com.example.liedetector.ui.theme.PrimaryColor
import com.example.liedetector.ui.theme.TextHeading
import com.example.liedetector.utils.ImageBackgroundBox
import ir.kaaveh.sdpcompose.sdp

@Composable
fun SplashScreen(navController: NavController) {

    ImageBackgroundBox(bgImage = R.mipmap.bg) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .weight(3f),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
            )
            SplashProgressBar(modifier = Modifier.weight(1f), navController)
        }
    }
}

@Composable
private fun SplashProgressBar(modifier: Modifier = Modifier, navController: NavController) {

    val viewModel = viewModel<SplashViewModel>()

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.LOADING),
            style = TextHeading,
            textAlign = TextAlign.Center
        )

        LinearProgressIndicator(
            progress = viewModel.currentProgress.value,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.sdp)
                .height(20.sdp)
                .clip(shape = RoundedCornerShape(size = 20.sdp)),
            color = PrimaryColor,
            trackColor = Color.White
        )
    }

    LaunchedEffect(key1 = viewModel.currentProgress.value) {
        if (viewModel.progressCompleted.value) {
            NavigationScreens.navigateToScreen(navController, NavigationScreens.FingerPrintScreen)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashContentPreview() {

}