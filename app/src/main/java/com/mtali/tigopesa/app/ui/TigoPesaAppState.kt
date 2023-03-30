package com.mtali.tigopesa.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.mtali.tigopesa.app.navigation.TopLevelDestination
import com.mtali.tigopesa.core.utils.trace
import com.mtali.tigopesa.feature.home.navigation.homeRoute
import com.mtali.tigopesa.feature.home.navigation.navigateToHome
import com.mtali.tigopesa.feature.self_care.navigation.navigateToSelfCare
import com.mtali.tigopesa.feature.self_care.navigation.selfCareRoute
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberTigoPesaAppState(): TigoPesaAppState {
    return TigoPesaAppState(
        navController = rememberNavController(),
        coroutineScope = rememberCoroutineScope()
    )
}

@Stable
class TigoPesaAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope
) {

    val currentDestination: NavDestination?
        @Composable get() = navController.currentDestination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            homeRoute -> TopLevelDestination.HOME
            selfCareRoute -> TopLevelDestination.SELF_CARE
            else -> null
        }

    fun navigateToTopLevelDestination(destination: TopLevelDestination) {
        trace("Navigation: ${destination.name}") {
            val topLevelNavOptions = navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }

                launchSingleTop = true

                restoreState = true
            }

            when (destination) {
                TopLevelDestination.HOME -> navController.navigateToHome(topLevelNavOptions)
                TopLevelDestination.SELF_CARE -> navController.navigateToSelfCare(topLevelNavOptions)
            }
        }
    }

}