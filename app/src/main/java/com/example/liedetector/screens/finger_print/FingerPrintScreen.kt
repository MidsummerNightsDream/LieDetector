package com.example.liedetector.screens.finger_print

import android.util.Log.e
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.liedetector.R
import com.example.liedetector.utils.ImageBackgroundBox
import com.example.liedetector.utils.commom_composables.TopBarHome

@Composable
fun FingerPrintScreen(navController: NavController) {
    ImageBackgroundBox(bgImage = R.mipmap.bg_2) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            TopBarHome(stringResource(id = R.string.))


        }
    }
}
