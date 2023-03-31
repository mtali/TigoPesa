package com.mtali.tigopesa.feature.bill_pay

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mtali.tigopesa.R
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
fun BillPayRoute(onBackClick: () -> Unit) {
    BillPayScreen(onBackClick = onBackClick)
}


@Composable
private fun BillPayScreen(
    onBackClick: () -> Unit
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

            actionButtons()

            height(16.dp)

            searchBiller()
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
    name: String, code: String
) {

    Column {
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

private fun LazyListScope.searchBiller() {
    item {
        Card {
            Column(Modifier.padding(vertical = 8.dp)) {
                TigoTextField(
                    value = "",
                    placeholder = R.string.search_by_biller_code_or_name,
                    modifier = Modifier.horizontal()
                )

                billers.forEach { BillerItem(it.name, it.code) }
            }

        }
    }
}