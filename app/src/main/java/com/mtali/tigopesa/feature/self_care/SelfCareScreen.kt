package com.mtali.tigopesa.feature.self_care

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mtali.tigopesa.core.ui.component.TigoToolbar
import com.mtali.tigopesa.core.ui.theme.BrightestGray


@Composable
fun SelfCareRoute() {
    SelfCareScreen()
}


@Composable
private fun SelfCareScreen() {
    Scaffold(
        topBar = { TigoToolbar(false) }
    ) { padding ->
        LazyColumn(
            Modifier
                .padding(padding)
                .fillMaxSize()
                .background(BrightestGray)
        ) {

        }
    }
}