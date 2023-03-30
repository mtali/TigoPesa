package com.mtali.tigopesa.feature.favourites.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mtali.tigopesa.feature.favourites.FavouritesRoute

const val favouritesRoute = "favourites_route"

fun NavController.navigateToFavourites(navOptions: NavOptions? = null) {
    this.navigate(favouritesRoute, navOptions = navOptions)
}

fun NavGraphBuilder.favouritesScreen(onBackClick: () -> Unit) {
    composable(route = favouritesRoute) {
        FavouritesRoute(onBackClick = onBackClick)
    }
}