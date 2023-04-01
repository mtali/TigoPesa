package com.mtali.tigopesa.feature.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mtali.tigopesa.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {


    var dialogUiState by mutableStateOf<HomeDialogUiState>(HomeDialogUiState.None)
        private set

    fun onGovernmentPayClick() {
        dialogUiState = HomeDialogUiState.ChoosePaymentMethod
    }

    fun onDialogCancel() {
        dialogUiState = HomeDialogUiState.None
    }

    companion object {
        val Banners = listOf(
            Banner(
                code = 1,
                title = R.string.promo_mastercard_title,
                description = R.string.promo_mastercard_description,
                image = R.drawable.ic_master_card
            ),
            Banner(
                code = 2,
                title = R.string.promo_levy_title,
                description = R.string.promo_levy_description,
                image = R.drawable.allocation
            ),
            Banner(
                code = 3,
                title = R.string.promo_pay_tip_title,
                description = R.string.promo_pay_tip_description,
                image = R.drawable.waiter_tip
            ),
            Banner(
                code = 3,
                title = R.string.promo_bustisha_title,
                description = R.string.promo_bustisha_description,
                image = R.drawable.benefits
            ),
        )
    }
}

sealed interface HomeDialogUiState {
    object None : HomeDialogUiState
    object ChoosePaymentMethod : HomeDialogUiState
}

data class Banner(
    val code: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)


