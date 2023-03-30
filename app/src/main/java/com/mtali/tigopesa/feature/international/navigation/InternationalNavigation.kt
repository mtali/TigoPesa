package com.mtali.tigopesa.feature.international.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mtali.tigopesa.feature.international.InternationalRoute

const val internationalRoute = "international_route"

fun NavController.navigateToInternational(navOptions: NavOptions? = null) {
    this.navigate(internationalRoute, navOptions = navOptions)
}

fun NavGraphBuilder.internationalScreen(onBackClick: () -> Unit) {
    composable(route = internationalRoute) {
        InternationalRoute(onBackClick = onBackClick)
    }
}