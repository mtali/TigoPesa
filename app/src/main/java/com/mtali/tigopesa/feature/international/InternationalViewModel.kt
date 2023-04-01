package com.mtali.tigopesa.feature.international

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InternationalViewModel @Inject constructor() : ViewModel() {
    companion object {
        val countries = listOf(
            "Botswana",
            "Burundi",
            "DRC",
            "Kenya",
            "Malawi",
            "Mozambique",
            "Rwanda",
            "South Sudan",
            "Uganda",
            "Zambia",
        )
    }
}
