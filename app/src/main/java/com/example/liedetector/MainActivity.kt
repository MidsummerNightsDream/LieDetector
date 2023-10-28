package com.example.liedetector

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.liedetector.navigation.NavigationScreens
import com.example.liedetector.screens.finger_print.FingerPrintScreen
import com.example.liedetector.screens.home.HomeScreen
import com.example.liedetector.screens.splash.SplashScreen
import com.example.liedetector.ui.theme.LieDetectorTheme
import com.example.liedetector.ui.theme.PrimaryColor
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LieDetectorTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = NavigationScreens.FingerPrintScreen.route) {
                    composable(NavigationScreens.SplashScreen.route) {
                        SplashScreen(navController)
                    }
//                    composable(NavigationScreens.HomeScreen.route) {
//                        HomeScreen(navController)
//                    }
                    composable(NavigationScreens.FingerPrintScreen.route) {
                        FingerPrintScreen(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val activity = LocalContext.current as Activity
    val scope = rememberCoroutineScope()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(PrimaryColor)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        NavigationBarIcon(
            iconResId = R.drawable.ic_finger_print,
        ) {
            NavigationScreens.navigateToScreen(navController, NavigationScreens.HomeScreen)
        }
        NavigationBarIcon(
            iconResId = R.drawable.ic_eye_detection,
        ) {
            NavigationScreens.navigateToScreen(navController, NavigationScreens.HomeScreen)
        }
        NavigationBarIcon(
            iconResId = R.drawable.ic_voice_detection,
        ) {
            NavigationScreens.navigateToScreen(navController, NavigationScreens.HomeScreen)
        }
    }
}

@Composable
private fun NavigationBarIcon(iconResId: Int, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .clickable {
                onClick.invoke()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = "Vector Drawable Icon",
            tint = Color.White,
            modifier = Modifier.size(40.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LieDetectorTheme {
    }
}