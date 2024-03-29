package com.mtali.tigopesa.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.mtali.tigopesa.app.navigation.TopLevelDestination
import com.mtali.tigopesa.core.utils.trace
import com.mtali.tigopesa.feature.home.navigation.navigateToHome
import com.mtali.tigopesa.feature.oboarding_choose_language.navigation.onboardingRoute
import com.mtali.tigopesa.feature.register_device.navigation.registerDeviceRoute
import com.mtali.tigopesa.feature.self_care.navigation.navigateToSelfCare

@Composable
fun rememberTigoPesaAppState(
    navController: NavHostController = rememberNavController()
): TigoPesaAppState {
    return remember(navController) {
        TigoPesaAppState(navController = navController)
    }
}

@Stable
class TigoPesaAppState(
    val navController: NavHostController,
) {

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

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

    fun onBackClick() {
        navController.popBackStack()
    }
}

fun NavDestination?.hasBottomNavigation(): Boolean {
    return when (this?.route) {
        registerDeviceRoute,
        onboardingRoute -> {
            false
        }

        else -> true
    }
}