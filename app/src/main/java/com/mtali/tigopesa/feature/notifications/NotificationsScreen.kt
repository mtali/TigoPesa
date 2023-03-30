package com.mtali.tigopesa.feature.notifications

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.component.TigoTopAppBar

@Composable
fun NotificationsRoute(onBackClick: () -> Unit) {
    NotificationsScreen(onBackClick = onBackClick)
}


@Composable
private fun NotificationsScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TigoTopAppBar(title = R.string.notifications, onBackClick = onBackClick)
        }
    ) {
        LazyColumn(Modifier.padding(it)) {

        }
    }
}