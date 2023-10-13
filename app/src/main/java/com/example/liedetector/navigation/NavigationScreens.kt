package com.example.liedetector.navigation

import androidx.navigation.NavController

sealed class NavigationScreens(val route: String) {

    object SplashScreen : NavigationScreens(SPLASH_SCREEN)
    object HomeScreen : NavigationScreens(HOME_SCREEN)
    object FingerPrintScreen : NavigationScreens(FINGER_PRINT_SCREEN)
    object EyeDetectionScreen : NavigationScreens(EYE_DETECTION_SCREEN)
    object VoiceDetectionScreen : NavigationScreens(VOICE_DETECTION_SCREEN)
    object LanguageScreen : NavigationScreens(LANGUAGE_SCREEN)

    companion object {
        private const val SPLASH_SCREEN = "splash_screen"
        private const val HOME_SCREEN = "home_screen"
        private const val FINGER_PRINT_SCREEN = "finger_print_screen"
        private const val EYE_DETECTION_SCREEN = "eye_detection_screen"
        private const val VOICE_DETECTION_SCREEN = "voice_detection_screen"
        private const val LANGUAGE_SCREEN = "language_screen"

        fun navigateToScreen(navController: NavController, navigationScreens: NavigationScreens) {
            when (navigationScreens) {
                is NavigationScreens.SplashScreen -> navController.navigate(NavigationScreens.SplashScreen.route)
                is NavigationScreens.HomeScreen -> navController.navigate(NavigationScreens.HomeScreen.route)
                is NavigationScreens.FingerPrintScreen -> navController.navigate(NavigationScreens.FingerPrintScreen.route)
                is NavigationScreens.EyeDetectionScreen -> navController.navigate(NavigationScreens.EyeDetectionScreen.route)
                is NavigationScreens.VoiceDetectionScreen -> navController.navigate(NavigationScreens.VoiceDetectionScreen.route)
                is NavigationScreens.LanguageScreen -> navController.navigate(NavigationScreens.LanguageScreen.route)
            }
        }
    }
}
