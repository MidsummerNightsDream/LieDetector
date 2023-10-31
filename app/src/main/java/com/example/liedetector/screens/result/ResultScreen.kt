package com.example.liedetector.screens.result

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.liedetector.R
import com.example.liedetector.navigation.NavigationScreens
import com.example.liedetector.screens.finger_print.FingerPrintViewModel
import com.example.liedetector.screens.finger_print.composables.HoldButton
import com.example.liedetector.screens.finger_print.composables.IconRow
import com.example.liedetector.screens.finger_print.composables.Lights
import com.example.liedetector.screens.finger_print.composables.Pulse
import com.example.liedetector.screens.result.components.RescanButton
import com.example.liedetector.utils.ImageBackgroundBox
import com.example.liedetector.utils.VerticalSpacer
import com.example.liedetector.utils.commom_composables.NavigationBar
import com.example.liedetector.utils.commom_composables.TopBarHome
import ir.kaaveh.sdpcompose.sdp

@Composable
fun ResultScreen(navController: NavController) {

    val viewModel = viewModel<ResultViewModel>()

    ImageBackgroundBox(bgImage = R.mipmap.bg_2) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.sdp),
        ) {
            TopBarHome(stringResource(id = R.string.Lie_Detector))
            VerticalSpacer(size = 40.sdp)
            Pulse()
            VerticalSpacer(size = 20.sdp)
            HoldButton()
            VerticalSpacer(size = 20.sdp)
            Lights()
            Spacer(modifier = Modifier.weight(1f))
            RescanButton() {
                NavigationScreens.navigateToScreen(navController, NavigationScreens.FingerPrintScreen)
            }
            VerticalSpacer(size = 70.sdp)
        }
    }
}