package com.mtali.tigopesa.feature.self_care

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.Height
import com.mtali.tigopesa.core.ui.Width
import com.mtali.tigopesa.core.ui.component.TigoPesaButton
import com.mtali.tigopesa.core.ui.component.TigoToolbar
import com.mtali.tigopesa.core.ui.component.featureVerticalSpacing
import com.mtali.tigopesa.core.ui.component.height
import com.mtali.tigopesa.core.ui.theme.Blue
import com.mtali.tigopesa.core.ui.theme.BrightestGray
import com.mtali.tigopesa.core.ui.theme.Green


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
                .background(BrightestGray)
                .padding(padding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)

        ) {
            height(16.dp)

            selfCareHeaderCard()

            height(16.dp)

            tigoPesaHeader()

            height(16.dp)

            mobileSettingHeader()

            height(16.dp)

            helpCenterCard()

            height(16.dp)

            referAndEarnCard()


        }
    }
}

private val miniFeatureHeight = 45.dp

private fun LazyListScope.tigoPesaHeader() {
    item {
        Card {
            Column {

                MiniFeatureTitle(title = R.string.tigo_pesa)

                val height = (miniFeatureHeight + featureVerticalSpacing) * 3
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalArrangement = Arrangement.spacedBy(featureVerticalSpacing),
                    userScrollEnabled = false,
                    modifier = Modifier.height(height)
                ) {
                    miniFeature(title = R.string.tigo_pesa_pin, icon = R.drawable.tigo_pesa_pin)
                    miniFeature(title = R.string.e_statement, icon = R.drawable.sc_estatement)
                    miniFeature(
                        title = R.string.transaction_reversal,
                        icon = R.drawable.transaction_reversal
                    )
                    miniFeature(title = R.string.my_activities, icon = R.drawable.my_activity)
                    miniFeature(title = R.string.luku_token, icon = R.drawable.luku)
                    miniFeature(title = R.string.my_numbers, icon = R.drawable.activity)
                    miniFeature(
                        title = R.string.unbar,
                        icon = R.drawable.ic_unbar_tigo_pesa_account
                    )
                    miniFeature(title = R.string.get_token, icon = R.drawable.luku)
                }
            }
        }
    }
}

private fun LazyListScope.mobileSettingHeader() {
    item {
        Card {
            Column {

                MiniFeatureTitle(title = R.string.mobile_settings)

                val height = (miniFeatureHeight + featureVerticalSpacing) * 1
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalArrangement = Arrangement.spacedBy(featureVerticalSpacing),
                    userScrollEnabled = false,
                    modifier = Modifier.height(height)
                ) {
                    miniFeature(title = R.string.device_connected, icon = R.drawable.device_list)
                    miniFeature(
                        title = R.string.notification_settings,
                        icon = R.drawable.ic_push_notification
                    )
                    miniFeature(
                        title = R.string.app_upgrade,
                        icon = R.drawable.tigo_pesa
                    )
                }
            }
        }
    }
}


private fun LazyListScope.helpCenterCard() {
    item {
        Card {
            Column {

                MiniFeatureTitle(title = R.string.help_center)

                val height = (miniFeatureHeight + featureVerticalSpacing) * 1
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalArrangement = Arrangement.spacedBy(featureVerticalSpacing),
                    userScrollEnabled = false,
                    modifier = Modifier.height(height)
                ) {
                    miniFeature(
                        title = R.string.customer_support,
                        icon = R.drawable.customer_support_icon
                    )
                    miniFeature(title = R.string.information, icon = R.drawable.information)
                }
            }
        }
    }
}

private fun LazyListScope.referAndEarnCard() {
    item {
        Card {
            Column {

                MiniFeatureTitle(title = R.string.refer_earn)

                val height = (miniFeatureHeight + featureVerticalSpacing) * 1
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalArrangement = Arrangement.spacedBy(featureVerticalSpacing),
                    userScrollEnabled = false,
                    modifier = Modifier.height(height)
                ) {
                    miniFeature(title = R.string.refer_earn, icon = R.drawable.refer_earn_dash)
                }
            }
        }
    }
}

private fun LazyGridScope.miniFeature(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    @DrawableRes icon: Int
) {
    item {
        Column(
            modifier = modifier
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = stringResource(id = title),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 12.sp,
                color = Blue
            )
        }
    }

}

private fun LazyListScope.selfCareHeaderCard() {
    item {
        Card {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Column(Modifier.weight(3f)) {
                    Text(
                        text = stringResource(id = R.string.my_name).uppercase(),
                        fontSize = 18.sp,
                        color = Blue,
                        fontWeight = FontWeight.SemiBold
                    )
                    Height(size = 8.dp)
                    Text(text = "Prepaid: +25571952****")
                    Height(size = 8.dp)
                    Row {
                        Row(modifier = Modifier.weight(1f)) {
                            Text(text = "Email: ")
                            Text(text = "(E-mail not set)", color = Blue)
                        }

                        Icon(
                            painter = painterResource(id = R.drawable.ic_edit_icon),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Height(size = 8.dp)
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Language")
                        Width(size = 4.dp)
                        Image(
                            painter = painterResource(id = R.drawable.flag_uk),
                            contentDescription = null,
                            modifier = Modifier.size(35.dp)
                        )
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowDown,
                            contentDescription = null,
                            tint = Blue
                        )
                    }
                }

                Divider(
                    modifier = Modifier
                        .height(120.dp)
                        .padding(horizontal = 8.dp)
                        .width(1.dp)
                )

                Column(
                    modifier = Modifier.weight(2f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.reregister),
                        contentDescription = null
                    )
                    Text(
                        text = "Registered Using Nida".uppercase(),
                        maxLines = 1,
                        color = Green,
                        letterSpacing = 0.1.sp,
                        fontSize = 10.sp

                    )
                    TigoPesaButton(
                        title = R.string.view_details,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

            }
        }
    }
}

@Composable
private fun MiniFeatureTitle(title: Int) {
    Text(
        text = stringResource(id = title),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        fontWeight = FontWeight.SemiBold
    )
}

