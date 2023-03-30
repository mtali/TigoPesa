package com.mtali.tigopesa.feature.bill_pay.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mtali.tigopesa.feature.bill_pay.BillPayRoute

const val billPayRoute = "bill_pay_route"

fun NavController.navigateToBillPay(navOptions: NavOptions? = null) {
    this.navigate(billPayRoute, navOptions = navOptions)
}


fun NavGraphBuilder.billPayScreen(onBackClick: () -> Unit) {
    composable(route = billPayRoute) {
        BillPayRoute(onBackClick = onBackClick)
    }
}