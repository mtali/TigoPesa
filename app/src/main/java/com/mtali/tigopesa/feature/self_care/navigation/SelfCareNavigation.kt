package com.mtali.tigopesa.feature.self_care.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mtali.tigopesa.feature.self_care.SelfCareRoute


private const val SELF_CARE_GRAPH_ROUTE_PATTERN = "self_care_graph"
const val selfCareRoute = "self_care_route"


fun NavController.navigateToSelfCare(navOptions: NavOptions? = null) {
    this.navigate(SELF_CARE_GRAPH_ROUTE_PATTERN, navOptions)
}


fun NavGraphBuilder.selfCareGraph(nestedGraphs: NavGraphBuilder.() -> Unit) {
    navigation(
        route = SELF_CARE_GRAPH_ROUTE_PATTERN,
        startDestination = selfCareRoute
    ) {
        composable(route = selfCareRoute) {
            SelfCareRoute()
        }
        nestedGraphs()
    }
}