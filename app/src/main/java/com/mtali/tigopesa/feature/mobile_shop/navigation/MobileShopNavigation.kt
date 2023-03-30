package com.mtali.tigopesa.feature.mobile_shop.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mtali.tigopesa.feature.mobile_shop.MobileShopRoute

const val mobileShopRoute = "mobile_shop_route"

fun NavController.navigateToMobileShop(navOptions: NavOptions? = null) {
    this.navigate(mobileShopRoute, navOptions = navOptions)
}

fun NavGraphBuilder.mobileShopScreen(onBackClick: () -> Unit) {
    composable(route = mobileShopRoute) {
        MobileShopRoute(onBackClick = onBackClick)
    }
}