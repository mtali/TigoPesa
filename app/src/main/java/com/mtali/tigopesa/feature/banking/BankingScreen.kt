package com.mtali.tigopesa.feature.banking

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.component.TigoTopAppBar
import com.mtali.tigopesa.core.ui.component.featureHeight
import com.mtali.tigopesa.core.ui.component.featureVerticalSpacing
import com.mtali.tigopesa.core.ui.component.tigoFeatureCard
import com.mtali.tigopesa.core.ui.height
import com.mtali.tigopesa.core.ui.horizontal


@Composable
fun BankingRoute(onBackClick: () -> Unit) {
    BankingScreen(onBackClick = onBackClick)
}

@Composable
private fun BankingScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = { TigoTopAppBar(title = R.string.banking, onBackClick = onBackClick) }
    ) {
        LazyColumn(
            Modifier
                .padding(it)
                .horizontal()
                .fillMaxSize()
        ) {

            height(16.dp)

            bankingFeatures()

        }
    }
}

private fun LazyListScope.bankingFeatures() {
    item {
        val height = (featureHeight + featureVerticalSpacing) * 2 + 8.dp
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(featureVerticalSpacing),
            userScrollEnabled = false,
            modifier = Modifier.height(height)
        ) {
            tigoFeatureCard(
                title = R.string.transfer_to_bank,
                icon = R.drawable.transfer_to_bank,
                onClick = {}
            )

            tigoFeatureCard(
                title = R.string.bank_to_wallet,
                icon = R.drawable.bank_to_tp,
                onClick = {}
            )
        }
    }
}