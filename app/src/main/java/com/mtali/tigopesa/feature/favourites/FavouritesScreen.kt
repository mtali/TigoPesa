package com.mtali.tigopesa.feature.favourites

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.component.TigoTopAppBar


@Composable
fun FavouritesRoute(onBackClick: () -> Unit) {
    FavouritesScreen(onBackClick = onBackClick)
}


@Composable
private fun FavouritesScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TigoTopAppBar(title = R.string.my_favourites, onBackClick = onBackClick)
        }
    ) {
        LazyColumn(Modifier.padding(it)) {

        }
    }
}