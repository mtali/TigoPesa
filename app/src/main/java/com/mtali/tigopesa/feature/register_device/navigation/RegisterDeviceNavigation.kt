package com.mtali.tigopesa.feature.register_device.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mtali.tigopesa.feature.register_device.RegisterDeviceRoute

const val registerDeviceRoute = "register_device_route"

fun NavController.navigateToRegisterDevice(navOptions: NavOptions? = null) {
    this.navigate(registerDeviceRoute, navOptions = navOptions)
}

fun NavGraphBuilder.registerDeviceScreen(onBackClick: () -> Unit, onDeviceRegistered: () -> Unit) {
    composable(registerDeviceRoute) {
        RegisterDeviceRoute(onBackClick = onBackClick, onDeviceRegistered = onDeviceRegistered)
    }
}