package com.mtali.tigopesa.feature.mobile_shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.component.TigoTopAppBar
import com.mtali.tigopesa.core.ui.component.featureHeight
import com.mtali.tigopesa.core.ui.component.featureVerticalSpacing
import com.mtali.tigopesa.core.ui.component.tigoFeatureCard
import com.mtali.tigopesa.core.ui.height
import com.mtali.tigopesa.core.ui.horizontal
import com.mtali.tigopesa.core.ui.theme.Blue
import com.mtali.tigopesa.core.ui.theme.LightBlue


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
            shopHeader()

            height(8.dp)

            featureGrid()
        }
    }
}


private fun LazyListScope.featureGrid(
    modifier: Modifier = Modifier,
) {
    item {
        val height = (featureHeight + featureVerticalSpacing) * 3
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(featureVerticalSpacing),
            userScrollEnabled = false,
            modifier = modifier
                .horizontal()
                .height(height)
        ) {
            tigoFeatureCard(
                icon = R.drawable.top_up,
                title = R.string.top_up,
                onClick = {}
            )
            tigoFeatureCard(
                icon = R.drawable.tigo_shop,
                title = R.string.buy_bundle,
                onClick = {}
            )
            tigoFeatureCard(
                icon = R.drawable.home_internet_icon,
                iconSize = 80.dp,
                title = null,
                onClick = {}
            )
            tigoFeatureCard(
                icon = R.drawable.lend_me,
                title = R.string.lend_services,
                onClick = {}
            )
            tigoFeatureCard(
                icon = R.drawable.ic_mobile_self_services,
                title = R.string.mobile_self_care,
                onClick = {}
            )
        }
    }
}

private fun LazyListScope.shopHeader() {
    item {
        Column(
            modifier = Modifier
                .background(LightBlue.copy(alpha = 0.1f))
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_tigo_shop_balance),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                    tint = Blue
                )
                Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                Text(text = "Airtime 0 Tsh")
            }
            Divider(Modifier.padding(vertical = 8.dp))
            Row(Modifier.fillMaxWidth()) {
                val modifier = Modifier.weight(1f)
                Metric(
                    modifier = modifier,
                    text = "0 MB",
                    res = R.drawable.ic_shop_data
                )
                Metric(
                    modifier = modifier,
                    text = "0 Sec",
                    res = R.drawable.ic_shop_voice
                )
                Metric(
                    modifier = modifier,
                    text = "9989 SMS",
                    res = R.drawable.ic_shop_sms
                )
            }
        }
    }
}

@Composable
private fun Metric(modifier: Modifier = Modifier, text: String, res: Int) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = res), contentDescription = null)
        Text(text = text)
    }
}