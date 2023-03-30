package com.mtali.tigopesa.feature.financial_services.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mtali.tigopesa.feature.financial_services.FinancialServicesRoute

const val financialServicesRoute = "financial_services_route"

fun NavController.navigateToFinancialServices(navOptions: NavOptions? = null) {
    this.navigate(financialServicesRoute, navOptions = navOptions)
}

fun NavGraphBuilder.financialServicesScreen(onBackClick: () -> Unit) {
    composable(route = financialServicesRoute) {
        FinancialServicesRoute(onBackClick = onBackClick)
    }
}