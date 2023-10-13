package com.example.liedetector.screens.splash

import androidx.compose.runtime.State
import androidx.compose.runtime.asFloatState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashViewModel : ViewModel() {

    private val _currentProgress = mutableFloatStateOf(0f)
    val currentProgress: State<Float> = _currentProgress.asFloatState()

    private val _progressCompleted = MutableStateFlow(false)
    val progressCompleted: StateFlow<Boolean> get() = _progressCompleted

    init {
        startLoading()
    }

    private fun startLoading() {
        viewModelScope.launch(Dispatchers.IO) {
            for (i in 1..100) {
                delay(5)
                withContext(Dispatchers.Main) {
                    _currentProgress.floatValue = i.toFloat() / 100f
                }            }
            _progressCompleted.value = true
        }
    }
}
