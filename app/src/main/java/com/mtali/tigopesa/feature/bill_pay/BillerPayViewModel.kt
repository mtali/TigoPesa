package com.mtali.tigopesa.feature.bill_pay

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BillerPayViewModel @Inject constructor() : ViewModel() {

    var selectedBiller by mutableStateOf<Biller?>(null)
        private set

    fun onSelectBiller(biller: Biller) {
        selectedBiller = biller
    }

    fun onBackClick(handler: () -> Unit) {
        if (selectedBiller == null) {
            handler()
        } else {
            selectedBiller = null
        }
    }

    companion object {
        val billers = listOf(
            Biller("LUKU", "001002"),
            Biller("TUKUZA", "878777"),
            Biller("Azam Pay TV", "144444"),
            Biller("DSTV", "300000"),
            Biller("ELIFE", "889900"),
            Biller("Air Tanzania", "787878"),
            Biller("GCSTanzania Ltd", "006688"),
            Biller("D Light Tz", "250011"),
            Biller("MOBISOL", "800200"),
            Biller("Precision Air", "333777"),
            Biller("4Pesa Limited", "444441"),
            Biller("A One Product Ltd", "444444"),
            Biller("AA TANCH", "267891"),
            Biller("AAR Insurance TZ", "761676"),
            Biller("Ada Lipa", "466466"),
            Biller("Ag Energies Co LTD", "122246"),
            Biller("AICT Kibaha", "565859"),
        )
    }
}

data class Biller(val name: String, val code: String)
