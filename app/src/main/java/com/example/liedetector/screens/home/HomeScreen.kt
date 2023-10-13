package com.example.liedetector.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.liedetector.BottomNavigationBar
import com.example.liedetector.R
import com.example.liedetector.utils.ImageBackgroundBox

@Composable
fun HomeScreen(navController: NavController) {
    ImageBackgroundBox(bgImage = R.mipmap.bg_2) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            BottomNavigationBar(navController)
        }
    }
}
