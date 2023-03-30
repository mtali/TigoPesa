package com.mtali.tigopesa.feature.send_money

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.component.TigoTopAppBar

@Composable
fun SendMoneyRoute(onBackClick: () -> Unit) {
    SendMoneyScreen(
        onBackClick = onBackClick
    )
}

@Composable
private fun SendMoneyScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TigoTopAppBar(title = R.string.send_money, onBackClick = onBackClick)
        }
    ) {
        LazyColumn(Modifier.padding(it)) {

        }
    }
}