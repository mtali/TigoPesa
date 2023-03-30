package com.mtali.tigopesa.feature.banking.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mtali.tigopesa.feature.banking.BankingRoute

const val bankingRoute = "banking_route"

fun NavController.navigateToBanking(navOptions: NavOptions? = null) {
    this.navigate(bankingRoute, navOptions = navOptions)
}

fun NavGraphBuilder.bankingScreen(onBackClick: () -> Unit) {
    composable(route = bankingRoute) {
        BankingRoute(onBackClick = onBackClick)
    }
}