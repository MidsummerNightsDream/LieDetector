package com.example.liedetector.classes

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator

class VibrationManager(private val context: Context) {

    private val vibrator: Vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    private var isVibrating = false

    private fun hasVibrator(): Boolean {
        return vibrator.hasVibrator()
    }

    fun vibrate(durationMillis: Long) {
        if (hasVibrator()) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                val vibrationEffect = VibrationEffect.createOneShot(durationMillis, VibrationEffect.DEFAULT_AMPLITUDE)
                vibrator.vibrate(vibrationEffect)
            } else {
                vibrator.vibrate(durationMillis)
            }
        }
    }

    fun sosVibrate() {
        if (hasVibrator() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val vibrationEffect = VibrationEffect.createWaveform(sosPattern, -1)
            vibrator.vibrate(vibrationEffect)
        } else if (hasVibrator()) {
            vibrator.vibrate(sosPattern, -1)
        }
    }

    fun startContinuousVibration() {
        if (hasVibrator() && !isVibrating) {
            isVibrating = true
            val pattern = longArrayOf(0, 1000) // Vibration pattern: ON for 1 second, OFF for 1 second
            vibrator.vibrate(pattern, 0) // Vibrate with the specified pattern and repeat index 0
        }
    }

    fun stopContinuousVibration() {
        if (isVibrating) {
            vibrator.cancel()
            isVibrating = false
        }
    }

    companion object {
        val sosPattern = longArrayOf(
            300, 200, 300, 200, 300, 200, 900, 200, 900, 200, 900, 200, // "S"
            300, 200, 900, 200, 300, 200, 900, 200, 300, 200, 300, 200, // "O"
            900, 200, 900, 200, 900, 200 // "S"
        )
    }
}