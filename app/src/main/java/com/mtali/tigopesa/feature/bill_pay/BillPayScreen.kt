package com.mtali.tigopesa.feature.bill_pay

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.component.TigoTopAppBar


@Composable
fun BillPayRoute(onBackClick: () -> Unit) {
    BillPayScreen(onBackClick = onBackClick)
}


@Composable
private fun BillPayScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TigoTopAppBar(title = R.string.bill_pay, onBackClick = onBackClick)
        }
    ) {
        LazyColumn(Modifier.padding(it)) {

        }
    }
}