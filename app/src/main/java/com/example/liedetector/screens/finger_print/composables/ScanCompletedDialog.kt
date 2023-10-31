package com.example.liedetector.screens.finger_print.composables

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.liedetector.R
import com.example.liedetector.ui.theme.GradientEndColor
import com.example.liedetector.ui.theme.GradientStartColor
import com.example.liedetector.ui.theme.PrimaryColor
import com.example.liedetector.ui.theme.TextHeading
import com.example.liedetector.ui.theme.TextNormal
import ir.kaaveh.sdpcompose.sdp


@Composable
fun ScanCompletedDialog(
    onSeeResults: () -> Unit,
    onDialogClose: () -> Unit,
) {
    Dialog(
        onDismissRequest = {
            onDialogClose.invoke()
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black),
        ) {
            Image(painter = painterResource(id = R.mipmap.bg_dialog), contentDescription = null)
            Column(
                modifier = Modifier.matchParentSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(20.dp),
                    text = stringResource(id = R.string.Scan_Successful),
                    color = PrimaryColor,
                    style = TextHeading
                )
                Text(
                    text = stringResource(id = R.string.See_Results),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.sdp)
                        .clickable {
                            onSeeResults.invoke()
                        }
                        .border(
                            width = 4.dp,
                            brush = Brush.verticalGradient(
                                colors = listOf(GradientStartColor, GradientEndColor)
                            ),
                            shape = RoundedCornerShape(size = 5.sdp)
                        )
                        .padding(10.sdp),
                    style = TextNormal,
                    textAlign = TextAlign.Center

                )
            }
        }
    }
}
