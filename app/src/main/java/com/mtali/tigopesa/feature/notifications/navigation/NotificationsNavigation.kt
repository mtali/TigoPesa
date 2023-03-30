package com.mtali.tigopesa.feature.notifications.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mtali.tigopesa.feature.notifications.NotificationsRoute


const val notificationsRoute = "notifications_route"

fun NavController.navigateToNotifications(navOptions: NavOptions? = null) {
    this.navigate(notificationsRoute, navOptions = navOptions)
}

fun NavGraphBuilder.notificationsScreen(onBackClick: () -> Unit) {
    composable(route = notificationsRoute) {
        NotificationsRoute(onBackClick = onBackClick)
    }
}