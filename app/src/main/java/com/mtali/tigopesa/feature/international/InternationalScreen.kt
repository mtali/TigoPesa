package com.mtali.tigopesa.feature.international

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.component.TigoTopAppBar

@Composable
fun InternationalRoute(onBackClick: () -> Unit) {
    InternationalScreen(onBackClick = onBackClick)
}


@Composable
private fun InternationalScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TigoTopAppBar(title = R.string.send_money_other_countries, onBackClick = onBackClick)
        }
    ) {
        LazyColumn(Modifier.padding(it)) {

        }
    }
}