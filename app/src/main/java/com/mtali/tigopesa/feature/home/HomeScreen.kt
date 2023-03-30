package com.mtali.tigopesa.feature.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.component.TigoToolbar
import com.mtali.tigopesa.core.ui.component.height
import com.mtali.tigopesa.core.ui.theme.Blue
import com.mtali.tigopesa.core.ui.theme.BrightestGray
import com.mtali.tigopesa.core.ui.theme.LogoYellow

@Composable
fun HomeRoute() {
    HomeScreen()
}

@Composable
private fun HomeScreen() {
    Scaffold(
        topBar = { TigoToolbar() }
    ) { padding ->
        LazyColumn(
            Modifier
                .padding(padding)
                .fillMaxSize()
                .background(BrightestGray)
        ) {
            height(8.dp)

            slidingNote(res = R.string.no_bundle_notice)

            height(8.dp)

            checkBalanceButton()

            height(20.dp)

            featureGrid()

        }
    }
}

private fun LazyListScope.checkBalanceButton() {
    item {
        Button(
            modifier = Modifier.horizontal(),
            onClick = { },
            colors = ButtonDefaults.buttonColors(backgroundColor = LogoYellow)
        ) {
            Icon(imageVector = Icons.Outlined.AccountBalance, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(id = R.string.check_balance))
        }
    }
}

private fun Modifier.horizontal() = this
    .fillMaxWidth()
    .padding(horizontal = 16.dp)


private fun LazyListScope.slidingNote(modifier: Modifier = Modifier, @StringRes res: Int) {
    item {
        Text(
            modifier = modifier.padding(4.dp),
            text = stringResource(id = res),
            maxLines = 1,
            color = Blue
        )
    }
}

private fun LazyListScope.featureGrid(
    modifier: Modifier = Modifier,
    onSendMoneyClick: () -> Unit = {},
    onBillPayClick: () -> Unit = {},
    onTransferToBankClick: () -> Unit = {},
    onCashOutClick: () -> Unit = {},
    onGovernmentPaymentsClick: () -> Unit = {},
    onTigoMobileShopClick: () -> Unit = {},
    onInternationalRemittanceClick: () -> Unit = {},
    onFinanceServiceClick: () -> Unit = {}

) {
    item {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            userScrollEnabled = false,
            modifier = modifier
                .horizontal()
                .height(500.dp)
        ) {
            featureCard(
                icon = R.drawable.send_money,
                title = R.string.send_money,
                onClick = onSendMoneyClick
            )
            featureCard(
                icon = R.drawable.bill_pay,
                title = R.string.bill_pay,
                onClick = onBillPayClick
            )
            featureCard(
                icon = R.drawable.transfer_to_bank,
                title = R.string.banking,
                onClick = onTransferToBankClick
            )
            featureCard(
                icon = R.drawable.cash_out,
                title = R.string.cash_out,
                onClick = onCashOutClick
            )
            featureCard(
                icon = R.drawable.government_payments,
                title = R.string.government_payments,
                onClick = onGovernmentPaymentsClick
            )
            featureCard(
                icon = R.drawable.tigo_mobile_shop,
                title = R.string.tigo_mobile_shop,
                onClick = onTigoMobileShopClick
            )
            featureCard(
                icon = R.drawable.ic_imt,
                title = R.string.international_remittance,
                onClick = onInternationalRemittanceClick
            )
            featureCard(
                icon = R.drawable.finance_service,
                title = R.string.finance_service,
                onClick = onFinanceServiceClick
            )
        }
    }
}


private fun LazyGridScope.featureCard(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    @StringRes title: Int,
    onClick: () -> Unit = {}
) {
    item {
        Card(modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable { onClick() }
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Text(text = stringResource(id = title))
            }
        }
    }

}

