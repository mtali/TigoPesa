package com.mtali.tigopesa.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mtali.tigopesa.feature.home.navigation.homeGraph
import com.mtali.tigopesa.feature.home.navigation.homeGraphRoutePattern
import com.mtali.tigopesa.feature.self_care.navigation.selfCareGraph

@Composable
fun TigoPesaNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = homeGraphRoutePattern
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeGraph {

        }

        selfCareGraph {

        }
    }
}