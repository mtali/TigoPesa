package com.mtali.tigopesa.feature.cash_out.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mtali.tigopesa.feature.cash_out.CashOutRoute

const val cashOutRoute = "cash_out_route"

fun NavController.navigateToCashOut(navOptions: NavOptions? = null) {
    this.navigate(cashOutRoute, navOptions = navOptions)
}

fun NavGraphBuilder.cashOutScreen(onBackClick: () -> Unit) {
    composable(route = cashOutRoute) {
        CashOutRoute(onBackClick = onBackClick)
    }
}