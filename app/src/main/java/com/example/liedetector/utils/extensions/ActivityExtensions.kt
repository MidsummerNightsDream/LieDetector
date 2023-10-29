package com.example.liedetector.utils.extensions

import android.app.Activity
import android.content.res.Configuration
import java.util.Locale

fun Activity.setLocale(languageCode: String?) {
    val locale = Locale(languageCode)
    Locale.setDefault(locale)
    val resources = resources
    val config: Configuration = resources.configuration
    config.setLocale(locale)
    resources.updateConfiguration(config, resources.displayMetrics)
}