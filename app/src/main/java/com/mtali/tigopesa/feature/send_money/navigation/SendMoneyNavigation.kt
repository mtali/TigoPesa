package com.mtali.tigopesa.feature.send_money.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mtali.tigopesa.feature.send_money.SendMoneyRoute

const val sendMoneyRoute = "send_money_route"

fun NavController.navigateToSendMoney(navOptions: NavOptions? = null) {
    this.navigate(sendMoneyRoute, navOptions = navOptions)
}

fun NavGraphBuilder.sendMoneyScreen(onBackClick: () -> Unit) {
    composable(route = sendMoneyRoute) {
        SendMoneyRoute(onBackClick = onBackClick)
    }
}