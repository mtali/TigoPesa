package com.mtali.tigopesa.feature.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    var currentOfferIndex by mutableStateOf(0)
        private set

    init {
        viewModelScope.launch {
            while (isActive) {
                currentOfferIndex = (currentOfferIndex + 1) % 3
                delay(3000)
            }
        }
    }
}
