package com.example.liedetector.screens.finger_print.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import com.example.liedetector.R
import com.example.liedetector.screens.finger_print.FingerPrintViewModel
import ir.kaaveh.sdpcompose.sdp

@Composable
fun IconRow(vm: FingerPrintViewModel, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 20.sdp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    vm.changeVibrationState()
                },
            painter = painterResource(id = if (vm.vibrationState.value) R.drawable.ic_vibrate_on else R.drawable.ic_vibrate_off),
            contentDescription = null
        )
        Image(
            modifier = Modifier
                .weight(2f)
                .clickable { }
                .pointerInput(Unit) {
                    detectTapGestures(
                        onPress = {
                            try {
                                vm.changePressedState()
                                awaitRelease()
                            } finally {
                                vm.changePressedState()
                            }
                        },
                    )
                },
            painter = painterResource(id = R.drawable.ic_finger_print_2),
            contentDescription = null
        )
        Image(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    vm.changeSoundState()
                },
            painter = painterResource(id = if (vm.soundState.value) R.drawable.ic_sound_on else R.drawable.ic_sound_off),
            contentDescription = null
        )
    }
}