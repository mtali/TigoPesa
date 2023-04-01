package com.mtali.tigopesa.feature.international

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.component.TigoPesaButton
import com.mtali.tigopesa.core.ui.component.TigoTextField
import com.mtali.tigopesa.core.ui.component.TigoTopAppBar
import com.mtali.tigopesa.core.ui.component.tigoPesaButton
import com.mtali.tigopesa.core.ui.component.tigoPesaDropdown
import com.mtali.tigopesa.core.ui.component.tigoTextField
import com.mtali.tigopesa.core.ui.height
import com.mtali.tigopesa.core.ui.horizontal
import com.mtali.tigopesa.core.ui.theme.Green
import com.mtali.tigopesa.feature.international.InternationalViewModel.Companion.countries

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
        Column(
            modifier = Modifier
                .padding(it)
                .horizontal()
        ) {

            Card {
                LazyColumn(
                    Modifier
                        .padding(it)
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {

                    internationalNotice()

                    height(16.dp)

                    tigoPesaDropdown(
                        modifier = Modifier.horizontal(),
                        title = R.string.country,
                        placeholder = R.string.select_country,
                        items = countries,
                        onSelectedIndexChange = {

                        }
                    )

                    height(8.dp)

                    tigoPesaDropdown(
                        modifier = Modifier.horizontal(),
                        title = R.string.network,
                        placeholder = R.string.select_network,
                        items = listOf("Airtel", "Safaricom", "Vodacom"),
                        onSelectedIndexChange = {

                        }
                    )

                    height(8.dp)

                    enterPhoneNumber(modifier = Modifier.horizontal())

                    height(8.dp)

                    tigoTextField(
                        modifier = Modifier.horizontal(),
                        title = R.string.to,
                        placeholder = R.string.ph_enter_phone_number,
                        value = "",
                    )

                    height(8.dp)

                    tigoTextField(
                        modifier = Modifier.horizontal(),
                        title = R.string.amount,
                        placeholder = R.string.ph_enter_amount_to_send,
                        value = "",
                    )

                    height(8.dp)

                    tigoTextField(
                        modifier = Modifier.horizontal(),
                        title = R.string.transaction_description,
                        placeholder = R.string.ph_enter_description,
                        value = "",
                    )

                    height(16.dp)

                    tigoPesaButton(
                        title = R.string.next,
                        onClick = {},
                        bgColor = Green,
                        uppercase = true,
                        modifier = Modifier
                            .horizontal()
                            .height(48.dp)
                    )


                }
            }
        }
    }
}

private fun LazyListScope.enterPhoneNumber(
    modifier: Modifier = Modifier,
    phoneNumber: String = "",
    onChoosePhoneNumberClick: () -> Unit = {},
    onPhoneNumberChange: (String) -> Unit = {},
) {
    item {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TigoTextField(
                title = R.string.to_all_networks,
                placeholder = R.string.ph_enter_phone_number,
                value = phoneNumber,
                onChangeValue = onPhoneNumberChange,
                modifier = Modifier.weight(1f),
            )
            Spacer(modifier = Modifier.width(14.dp))

            TigoPesaButton(
                title = R.string.choose,
                onClick = onChoosePhoneNumberClick,
                modifier = Modifier
                    .height(50.dp)
                    .align(Alignment.Bottom)
            )
        }
    }
}


fun LazyListScope.internationalNotice() {
    item {
        Row(
            Modifier
                .fillMaxWidth()
                .background(Color.LightGray.copy(alpha = 0.2f))
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.international_remit_notice),
                color = Color.Black,
                fontSize = 14.sp
            )
        }
    }
}