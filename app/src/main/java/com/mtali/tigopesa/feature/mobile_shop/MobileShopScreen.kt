package com.mtali.tigopesa.feature.mobile_shop

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.component.TigoTopAppBar


@Composable
fun MobileShopRoute(onBackClick: () -> Unit) {
    MobileShopScreen(onBackClick = onBackClick)
}


@Composable
private fun MobileShopScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TigoTopAppBar(title = R.string.tigo_mobile_shop, onBackClick = onBackClick)
        }
    ) {
        LazyColumn(Modifier.padding(it)) {

        }
    }
}