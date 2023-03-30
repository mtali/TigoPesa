package com.mtali.tigopesa.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mtali.tigopesa.feature.bill_pay.navigation.billPayScreen
import com.mtali.tigopesa.feature.bill_pay.navigation.navigateToBillPay
import com.mtali.tigopesa.feature.home.navigation.homeGraph
import com.mtali.tigopesa.feature.home.navigation.homeGraphRoutePattern
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
            nestedGraphs = {
                billPayScreen(onBackClick = onBackClick)

                sendMoneyScreen(onBackClick = onBackClick)
            }
        )

        selfCareGraph {

        }
    }
}