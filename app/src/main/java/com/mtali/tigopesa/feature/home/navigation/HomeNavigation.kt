package com.mtali.tigopesa.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mtali.tigopesa.feature.home.HomeRoute

const val homeGraphRoutePattern = "home_graph"
const val homeRoute = "home_route"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(homeGraphRoutePattern, navOptions)
}

fun NavGraphBuilder.homeGraph(
    nestedGraphs: NavGraphBuilder.() -> Unit,
    onSendMoneyClick: () -> Unit,
    onBillPayClick: () -> Unit,
    onTransferToBankClick: () -> Unit,
    onCashOutClick: () -> Unit,
    onTigoMobileShopClick: () -> Unit,
    onInternationalRemittanceClick: () -> Unit,
    onFinanceServiceClick: () -> Unit,
    onFavoritesClick: () -> Unit,
    onNotificationsClick: () -> Unit,
) {
    navigation(
        route = homeGraphRoutePattern,
        startDestination = homeRoute
    ) {
        composable(route = homeRoute) {
            HomeRoute(
                onSendMoneyClick = onSendMoneyClick,
                onBillPayClick = onBillPayClick,
                onTransferToBankClick = onTransferToBankClick,
                onCashOutClick = onCashOutClick,
                onTigoMobileShopClick = onTigoMobileShopClick,
                onInternationalRemittanceClick = onInternationalRemittanceClick,
                onFinanceServiceClick = onFinanceServiceClick,
                onFavoritesClick = onFavoritesClick,
                onNotificationsClick = onNotificationsClick
            )
        }
        nestedGraphs()
    }
}