package com.mtali.tigopesa.feature.oboarding_choose_language.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mtali.tigopesa.feature.oboarding_choose_language.OnboardChooseLanguageRoute

const val onboardingRoute = "onboarding_route"

fun NavController.navigateToOnboarding(navOptions: NavOptions? = null) {
    this.navigate(onboardingRoute, navOptions = navOptions)
}

fun NavGraphBuilder.onboardingScreen(onLanguageSelected: () -> Unit) {
    composable(onboardingRoute) {
        OnboardChooseLanguageRoute(onLanguageSelected = onLanguageSelected)
    }
}