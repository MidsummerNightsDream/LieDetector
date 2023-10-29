package com.example.liedetector.screens.finger_print

import android.app.Application
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.liedetector.classes.VibrationManager
import com.example.liedetector.utils.extensions.toast
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FingerPrintViewModel(application: Application) : AndroidViewModel(application) {

    private val vibrator = VibrationManager(application)

    private val _fingerPressedState = mutableStateOf(false)
    val fingerPressedState: State<Boolean> get() = _fingerPressedState

    private val _vibrationState = mutableStateOf(false)
    val vibrationState: State<Boolean> get() = _vibrationState

    private val _soundState = mutableStateOf(false)
    val soundState: State<Boolean> get() = _soundState

    private val _pressDuration = MutableStateFlow(0L)
    val pressDuration = _pressDuration.asStateFlow()

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

    fun startPressTimer() {
        viewModelScope.launch {
            var startTime = System.currentTimeMillis()
            while (true) {
                delay(1000) // Update the duration every second
                val elapsedTime = System.currentTimeMillis() - startTime
                _pressDuration.value = elapsedTime
                if (elapsedTime >= 10000) { // 10 seconds
                    onLongPressThresholdReached()
                    break
                }
            }
        }
    }

    fun stopPressTimer() {
        viewModelScope.launch {
            _pressDuration.value = 0L
        }
    }

    private fun onLongPressThresholdReached() {
        Log.e("TAG", "onLongPressThresholdReached: ", )
    }
}
