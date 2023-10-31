package com.example.liedetector.screens.eye_detection

import android.Manifest
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.liedetector.R
import com.example.liedetector.classes.CameraXHelper
import com.example.liedetector.screens.eye_detection.components.CameraPreview
import com.example.liedetector.screens.finger_print.FingerPrintViewModel
import com.example.liedetector.screens.finger_print.composables.HoldButton
import com.example.liedetector.screens.finger_print.composables.IconRow
import com.example.liedetector.screens.finger_print.composables.Lights
import com.example.liedetector.screens.finger_print.composables.Pulse
import com.example.liedetector.utils.ImageBackgroundBox
import com.example.liedetector.utils.VerticalSpacer
import com.example.liedetector.utils.commom_composables.NavigationBar
import com.example.liedetector.utils.commom_composables.TopBarHome
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import ir.kaaveh.sdpcompose.sdp

@Composable
fun EyeDetectionScreen(navController: NavController) {

    val viewModel = viewModel<EyeDetectionViewModel>()
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraXHelper = CameraXHelper(context, lifecycleOwner)
    val controller = remember {
        LifecycleCameraController(context).apply {
            setEnabledUseCases(
                CameraController.IMAGE_CAPTURE or
                        CameraController.VIDEO_CAPTURE
            )
        }
    }
    var cameraPermission by remember { mutableStateOf<Boolean>(false) }
    CameraPermission() { cameraPermission = it }

    ImageBackgroundBox(bgImage = R.mipmap.bg_2) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.sdp),
        ) {
            TopBarHome(stringResource(id = R.string.Eye_Detection_Screen))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                CameraPreview(
                    modifier = Modifier
                        .matchParentSize().padding(20.sdp), cameraXHelper
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_eye_lens), contentDescription = null, tint = Color.White)
                    Icon(painter = painterResource(id = R.drawable.ic_eye_lens), contentDescription = null, tint = Color.White)
                }
            }
            NavigationBar()
        }
    }
}

@Composable
fun CameraPreview(modifier: Modifier = Modifier, cameraXHelper: CameraXHelper) {
    AndroidView(
        modifier = modifier,
        factory = {
            cameraXHelper.startCameraPreviewView()
        },
        update = {
            it.removeAllViews()
            it.addView(cameraXHelper.startCameraPreviewView())
        },

        )
}


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraPermission(permissionGranted: (Boolean) -> Unit) {
    val locationPermissionsState = rememberMultiplePermissionsState(
        listOf(
            Manifest.permission.CAMERA
        )
    )

    if (locationPermissionsState.allPermissionsGranted) {
        permissionGranted.invoke(true)
    } else {
        SideEffect {
            locationPermissionsState.launchMultiplePermissionRequest()
        }
    }
}
