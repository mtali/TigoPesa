package com.mtali.tigopesa.feature.bill_pay

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warehouse
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.Height
import com.mtali.tigopesa.core.ui.component.TigoPesaButton
import com.mtali.tigopesa.core.ui.component.TigoTextField
import com.mtali.tigopesa.core.ui.component.TigoTopAppBar
import com.mtali.tigopesa.core.ui.height
import com.mtali.tigopesa.core.ui.horizontal
import com.mtali.tigopesa.core.ui.theme.Blue
import com.mtali.tigopesa.core.ui.theme.BrightestGray
import com.mtali.tigopesa.core.ui.theme.Green
import com.mtali.tigopesa.feature.bill_pay.BillerPayViewModel.Companion.billers


@Composable
fun BillPayRoute(viewModel: BillerPayViewModel = hiltViewModel(), onBackClick: () -> Unit) {

    val selectedBiller = viewModel.selectedBiller

    BillPayScreen(
        onBackClick = { viewModel.onBackClick(onBackClick) },
        selectedBiller = selectedBiller,
        onSelectBiller = viewModel::onSelectBiller
    )
}


@Composable
private fun BillPayScreen(
    onBackClick: () -> Unit,
    selectedBiller: Biller?,
    onSelectBiller: (Biller) -> Unit
) {
    Scaffold(
        topBar = { TigoTopAppBar(title = R.string.bill_pay, onBackClick = onBackClick) }
    ) {

        LazyColumn(
            Modifier
                .padding(it)
                .fillMaxSize()
                .horizontal()
        ) {

            height(16.dp)

            if (selectedBiller == null) {
                actionButtons()

                height(16.dp)

                searchBiller(
                    onSelectBiller = onSelectBiller
                )
            } else {
                payBillForm(selectedBiller)
            }

        }
    }
}

@Composable
private fun InfoCircle(name: String, code: String) {
    Row {
        Icon(imageVector = Icons.Filled.Warehouse, contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = name, fontWeight = FontWeight.SemiBold)
            Text(text = code, fontWeight = FontWeight.Normal)
        }
    }
}


private fun LazyListScope.payBillForm(biller: Biller) {
    item {
        Card {
            Column(Modifier.padding(16.dp)) {
                Text(text = "You will pay to", fontWeight = FontWeight.SemiBold)

                Height(size = 8.dp)

                InfoCircle(name = biller.name, code = biller.code)

                Height(size = 8.dp)

                TigoTextField(
                    value = "",
                    placeholder = R.string.reference_number,
                    title = R.string.reference_number
                )

                Height(size = 8.dp)

                TigoTextField(
                    value = "",
                    placeholder = R.string.amount,
                    title = R.string.ph_enter_amount_to_pay
                )

                Height(size = 8.dp)

                TigoTextField(
                    value = "",
                    placeholder = R.string.transaction_description,
                    title = R.string.ph_enter_description,
                )
            }
        }
    }
}

private fun LazyListScope.actionButtons() {
    item {
        Card {
            Column(Modifier.padding(16.dp)) {
                TigoPesaButton(
                    title = R.string.scan_qr_code_and_pay,
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    bgColor = Blue,
                    uppercase = true
                )
                Spacer(modifier = Modifier.height(16.dp))
                TigoPesaButton(
                    title = R.string.select_category,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    onClick = { },
                    bgColor = Green,
                    uppercase = true
                )
            }
        }
    }
}

@Composable
private fun BillerItem(
    name: String, code: String, onClick: () -> Unit
) {

    Column(modifier = Modifier.clickable { onClick() }) {
        Row(
            modifier = Modifier
                .horizontal()
                .padding(vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
            )

            Text(text = " ($code)", fontSize = 16.sp)
        }

        Divider(
            startIndent = 4.dp,
            color = BrightestGray
        )
    }
}

private fun LazyListScope.searchBiller(
    onSelectBiller: (Biller) -> Unit
) {
    item {
        Card {
            Column(Modifier.padding(vertical = 8.dp)) {
                TigoTextField(
                    value = "",
                    placeholder = R.string.search_by_biller_code_or_name,
                    modifier = Modifier.horizontal()
                )

                billers.forEach {
                    BillerItem(
                        name = it.name,
                        code = it.code,
                        onClick = {
                            onSelectBiller(it)
                        }
                    )
                }
            }

        }
    }
}