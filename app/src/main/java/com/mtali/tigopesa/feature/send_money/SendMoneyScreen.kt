package com.mtali.tigopesa.feature.send_money

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.component.TigoPesaButton
import com.mtali.tigopesa.core.ui.component.TigoTextField
import com.mtali.tigopesa.core.ui.component.TigoTopAppBar
import com.mtali.tigopesa.core.ui.component.tigoPesaButton
import com.mtali.tigopesa.core.ui.component.tigoPesaCheckBox
import com.mtali.tigopesa.core.ui.component.tigoTextField
import com.mtali.tigopesa.core.ui.height
import com.mtali.tigopesa.core.ui.horizontal
import com.mtali.tigopesa.core.ui.theme.Green

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
        LazyColumn(
            Modifier
                .padding(it)
                .horizontal()
        ) {

            height(16.dp)

            enterPhoneNumber()

            height(10.dp)

            tigoTextField(
                title = R.string.amount,
                placeholder = R.string.ph_enter_amount,
                value = "",
                onChangeValue = {}
            )
            height(10.dp)

            tigoTextField(
                title = R.string.transaction_description,
                placeholder = R.string.ph_enter_description,
                value = "",
                onChangeValue = {}
            )

            height(10.dp)

            tigoPesaCheckBox(
                text = R.string.send_with_cash_out_fees,
                checked = false,
                onCheckedChange = {}
            )

            tigoPesaCheckBox(
                text = R.string.send_as_voucher,
                checked = false,
                onCheckedChange = {}
            )

            tigoPesaButton(
                title = R.string.next,
                onClick = {},
                bgColor = Green,
                uppercase = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            )
        }
    }
}

fun LazyListScope.enterPhoneNumber(
    phoneNumber: String = "",
    onChoosePhoneNumberClick: () -> Unit = {},
    onPhoneNumberChange: (String) -> Unit = {},
) {
    item {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TigoTextField(
                title = R.string.to_all_networks,
                placeholder = R.string.ph_enter_phone_number,
                value = phoneNumber,
                onChangeValue = onPhoneNumberChange,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(14.dp))

            TigoPesaButton(
                title = R.string.choose,
                onClick = onChoosePhoneNumberClick,
                modifier = Modifier
                    .height(56.dp)
                    .align(Alignment.Bottom)
            )
        }
    }
}