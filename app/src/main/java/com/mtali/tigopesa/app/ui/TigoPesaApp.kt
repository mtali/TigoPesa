package com.mtali.tigopesa.app.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.mtali.tigopesa.app.navigation.TigoPesaNavHost
import com.mtali.tigopesa.app.navigation.TopLevelDestination
import com.mtali.tigopesa.core.ui.component.TigoPesaNavigationBarItem
import com.mtali.tigopesa.core.ui.theme.Blue


@Composable
fun TigoPesaApp(appState: TigoPesaAppState = rememberTigoPesaAppState()) {
    Scaffold(
        bottomBar = {
            TigoPesaBottomBar(
                destinations = TopLevelDestination.values().toList(),
                currentDestination = appState.currentDestination,
                onNavigateToDestination = appState::navigateToTopLevelDestination
            )
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            TigoPesaNavHost(appState.navController)
        }
    }
}

@Composable
fun TigoPesaBottomBar(
    destinations: List<TopLevelDestination>,
    currentDestination: NavDestination?,
    onNavigateToDestination: (TopLevelDestination) -> Unit
) {
    BottomAppBar(
        backgroundColor = Blue
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            TigoPesaNavigationBarItem(
                label = destination.title,
                icon = destination.icon,
                onClick = { onNavigateToDestination(destination) },
                selected = selected
            )
        }
    }

}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false