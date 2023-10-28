package com.example.liedetector.utils.commom_composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.liedetector.R
import ir.kaaveh.sdpcompose.sdp

@Composable
fun NavigationBar(modifier: Modifier = Modifier){
    Row (
        modifier = modifier.fillMaxWidth().padding(vertical = 10.sdp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(modifier = Modifier.weight(1f).size(24.sdp), painter = painterResource(id = R.drawable.ic_finger_print), contentDescription = null, tint = Color.White)
        Icon(modifier = Modifier.weight(1f).size(24.sdp), painter = painterResource(id = R.drawable.ic_eye_detection), contentDescription = null, tint = Color.White)
        Icon(modifier = Modifier.weight(1f).size(24.sdp), painter = painterResource(id = R.drawable.ic_voice_detection), contentDescription = null, tint = Color.White)
    }
}