package com.mtali.tigopesa.feature.cash_out

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.component.TigoTopAppBar
import com.mtali.tigopesa.core.ui.component.tigoPesaButton
import com.mtali.tigopesa.core.ui.component.tigoTextField
import com.mtali.tigopesa.core.ui.height
import com.mtali.tigopesa.core.ui.horizontal
import com.mtali.tigopesa.core.ui.theme.Green

@Composable
fun CashOutRoute(onBackClick: () -> Unit) {
    CashOutScreen(onBackClick = onBackClick)
}


@Composable
private fun CashOutScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TigoTopAppBar(title = R.string.cash_out, onBackClick = onBackClick)
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

                    cashOutNotice()

                    height(16.dp)

                    tigoTextField(
                        modifier = Modifier.horizontal(),
                        title = R.string.from,
                        placeholder = R.string.ph_enter_agent_number,
                        value = "",
                        onChangeValue = {}
                    )

                    height(10.dp)

                    tigoTextField(
                        modifier = Modifier.horizontal(),
                        title = R.string.amount,
                        placeholder = R.string.ph_enter_amount_to_send,
                        value = "",
                        onChangeValue = {}
                    )
                    height(10.dp)

                    tigoTextField(
                        modifier = Modifier.horizontal(),
                        title = R.string.transaction_description,
                        placeholder = R.string.ph_enter_description,
                        value = "",
                        onChangeValue = {}
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

private fun LazyListScope.cashOutNotice() {
    item {
        Row(
            Modifier
                .fillMaxWidth()
                .background(Color.LightGray.copy(alpha = 0.2f))
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.cash_out_notice),
                color = Color.Black,
                fontSize = 14.sp
            )
        }
    }

}