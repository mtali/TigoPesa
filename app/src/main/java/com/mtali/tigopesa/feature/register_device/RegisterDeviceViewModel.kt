package com.mtali.tigopesa.feature.register_device

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterDeviceViewModel @Inject constructor() : ViewModel() {

    var showForm by mutableStateOf(false)
        private set

    fun onBackClick(handler: () -> Unit) {
        if (showForm) {
            showForm = false
        } else {
            handler()
        }
    }

    fun onNumberConfirmed() {
        showForm = true
    }
}