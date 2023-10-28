package com.example.liedetector.screens.finger_print

import android.util.Log.e
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.liedetector.R
import com.example.liedetector.screens.finger_print.composables.HoldButton
import com.example.liedetector.screens.finger_print.composables.IconRow
import com.example.liedetector.screens.finger_print.composables.Lights
import com.example.liedetector.screens.finger_print.composables.Pulse
import com.example.liedetector.utils.ImageBackgroundBox
import com.example.liedetector.utils.VerticalSpacer
import com.example.liedetector.utils.commom_composables.NavigationBar
import com.example.liedetector.utils.commom_composables.TopBarHome
import ir.kaaveh.sdpcompose.sdp

@Composable
fun FingerPrintScreen(navController: NavController? = null) {

    val viewModel = viewModel<FingerPrintViewModel>()

    ImageBackgroundBox(bgImage = R.mipmap.bg_2) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.sdp),
        ) {
            TopBarHome(stringResource(id = R.string.Finger_Print_Screen))
            VerticalSpacer(size = 40.sdp)
            Pulse()
            VerticalSpacer(size = 20.sdp)
            HoldButton()
            VerticalSpacer(size = 20.sdp)
            Lights()
            Spacer(modifier = Modifier.weight(1f))
            IconRow(viewModel)
            NavigationBar()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FingerPrintPreview() {
    FingerPrintScreen()
}