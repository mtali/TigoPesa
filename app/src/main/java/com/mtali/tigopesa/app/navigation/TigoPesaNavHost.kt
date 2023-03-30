package com.mtali.tigopesa.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mtali.tigopesa.feature.banking.navigation.bankingScreen
import com.mtali.tigopesa.feature.banking.navigation.navigateToBanking
import com.mtali.tigopesa.feature.bill_pay.navigation.billPayScreen
import com.mtali.tigopesa.feature.bill_pay.navigation.navigateToBillPay
import com.mtali.tigopesa.feature.cash_out.navigation.cashOutScreen
import com.mtali.tigopesa.feature.cash_out.navigation.navigateToCashOut
import com.mtali.tigopesa.feature.favourites.navigation.favouritesScreen
import com.mtali.tigopesa.feature.favourites.navigation.navigateToFavourites
import com.mtali.tigopesa.feature.financial_services.navigation.financialServicesScreen
import com.mtali.tigopesa.feature.financial_services.navigation.navigateToFinancialServices
import com.mtali.tigopesa.feature.home.navigation.homeGraph
import com.mtali.tigopesa.feature.home.navigation.homeGraphRoutePattern
import com.mtali.tigopesa.feature.international.navigation.internationalScreen
import com.mtali.tigopesa.feature.international.navigation.navigateToInternational
import com.mtali.tigopesa.feature.mobile_shop.navigation.mobileShopScreen
import com.mtali.tigopesa.feature.mobile_shop.navigation.navigateToMobileShop
import com.mtali.tigopesa.feature.notifications.navigation.navigateToNotifications
import com.mtali.tigopesa.feature.notifications.navigation.notificationsScreen
import com.mtali.tigopesa.feature.self_care.navigation.selfCareGraph
import com.mtali.tigopesa.feature.send_money.navigation.navigateToSendMoney
import com.mtali.tigopesa.feature.send_money.navigation.sendMoneyScreen

@Composable
fun TigoPesaNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = homeGraphRoutePattern,
    onBackClick: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeGraph(
            onSendMoneyClick = { navController.navigateToSendMoney() },
            onBillPayClick = { navController.navigateToBillPay() },
            onTransferToBankClick = { navController.navigateToBanking() },
            onCashOutClick = { navController.navigateToCashOut() },
            onTigoMobileShopClick = { navController.navigateToMobileShop() },
            onInternationalRemittanceClick = { navController.navigateToInternational() },
            onFinanceServiceClick = { navController.navigateToFinancialServices() },
            onFavoritesClick = { navController.navigateToFavourites() },
            onNotificationsClick = { navController.navigateToNotifications() },
            nestedGraphs = {
                billPayScreen(onBackClick = onBackClick)

                sendMoneyScreen(onBackClick = onBackClick)

                bankingScreen(onBackClick = onBackClick)

                cashOutScreen(onBackClick = onBackClick)

                mobileShopScreen(onBackClick = onBackClick)

                internationalScreen(onBackClick = onBackClick)

                financialServicesScreen(onBackClick = onBackClick)

                notificationsScreen(onBackClick = onBackClick)

                favouritesScreen(onBackClick = onBackClick)
            }
        )

        selfCareGraph {

        }
    }
}