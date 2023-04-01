package com.mtali.tigopesa.feature.financial_services

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.Height
import com.mtali.tigopesa.core.ui.component.TigoPesaButton
import com.mtali.tigopesa.core.ui.component.TigoTopAppBar
import com.mtali.tigopesa.core.ui.component.featureHeight
import com.mtali.tigopesa.core.ui.component.featureVerticalSpacing
import com.mtali.tigopesa.core.ui.component.height
import com.mtali.tigopesa.core.ui.component.tigoFeatureCard
import com.mtali.tigopesa.core.ui.theme.Blue
import com.mtali.tigopesa.core.ui.theme.BrightestGray

@Composable
fun FinancialServicesRoute(onBackClick: () -> Unit) {
    FinancialServicesScreen(onBackClick = onBackClick)
}


@Composable
private fun FinancialServicesScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TigoTopAppBar(title = R.string.finance_service, onBackClick = onBackClick)
        }
    ) {
        LazyColumn(
            Modifier
                .background(BrightestGray)
                .padding(it)
                .padding(horizontal = 16.dp)
                .fillMaxSize()

        ) {

            height(16.dp)

            featureGrid()

            helpCard()


        }
    }
}

private fun LazyListScope.helpCard() {
    item {
        Card {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(Modifier.weight(3.5f)) {
                    Text(text = stringResource(id = R.string.need_help))
                    Height(size = 4.dp)
                    Text(text = stringResource(id = R.string.need_help_description))
                    Height(size = 4.dp)
                    TigoPesaButton(
                        modifier = Modifier
                            .height(30.dp)
                            .fillMaxWidth(),
                        title = R.string.call_customer_care,
                        bgColor = Blue
                    )
                }
                Icon(
                    modifier = Modifier
                        .weight(1f)
                        .size(60.dp),
                    painter = painterResource(id = R.drawable.ipo_help),
                    contentDescription = null,
                    tint = Blue
                )
            }
        }

    }
}

private fun LazyListScope.featureGrid(modifier: Modifier = Modifier) {
    item {
        val height = (featureHeight + featureVerticalSpacing) * 3
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(featureVerticalSpacing),
            userScrollEnabled = false,
            modifier = modifier
                .height(height)
        ) {
            tigoFeatureCard(
                icon = R.drawable.visa_card_logo,
                iconSize = featureHeight,
                title = null,
                onClick = {}
            )
            tigoFeatureCard(
                icon = R.drawable.loan,
                title = R.string.loans,
                onClick = {}
            )
            tigoFeatureCard(
                icon = R.drawable.ic_insurance,
                title = R.string.insurance,
                onClick = {}
            )
            tigoFeatureCard(
                icon = R.drawable.saving_icon,
                title = R.string.savings,
                onClick = {}
            )
            tigoFeatureCard(
                icon = R.drawable.virtual_card,
                title = R.string.virtual_card_tile,
                onClick = {}
            )
        }
    }
}

/**
 * visa_card
 * loan
 * ic_insurance
 * saving_icon
 * virtual_card
 * ipo_help
 */