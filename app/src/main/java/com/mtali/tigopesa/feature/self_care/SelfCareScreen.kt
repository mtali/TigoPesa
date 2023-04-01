package com.mtali.tigopesa.feature.self_care

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.Height
import com.mtali.tigopesa.core.ui.Width
import com.mtali.tigopesa.core.ui.component.TigoPesaButton
import com.mtali.tigopesa.core.ui.component.TigoToolbar
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
                    Text(text = "Prepaid: +255719526215")
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
                        fontSize = 12.sp

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

