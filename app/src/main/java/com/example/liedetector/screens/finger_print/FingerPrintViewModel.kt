package com.example.liedetector.screens.finger_print

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.liedetector.classes.VibrationManager

class FingerPrintViewModel(application: Application) : AndroidViewModel(application) {

    private val vibrator = VibrationManager(application)

    private val _fingerPressedState = mutableStateOf(false)
    val fingerPressedState: State<Boolean> get() = _fingerPressedState

    private val _vibrationState = mutableStateOf(false)
    val vibrationState: State<Boolean> get() = _vibrationState

    private val _soundState = mutableStateOf(false)
    val soundState: State<Boolean> get() = _soundState

    fun changePressedState() {
        if (_fingerPressedState.value) {
            vibrator.stopContinuousVibration()
        } else {
            vibrator.startContinuousVibration()
        }
        _fingerPressedState.value = !_fingerPressedState.value
    }

    fun changeVibrationState(){
        _vibrationState.value = !_vibrationState.value
    }

    fun changeSoundState(){
        _soundState.value = !_soundState.value
    }
}
