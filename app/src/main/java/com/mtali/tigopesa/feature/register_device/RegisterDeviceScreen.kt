package com.mtali.tigopesa.feature.register_device

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.component.GreenButton
import com.mtali.tigopesa.core.ui.component.TigoTextField
import com.mtali.tigopesa.ui.theme.Blue

@Composable
fun RegisterDeviceRoute() {
    RegisterDeviceScreen()
}


@Composable
private fun RegisterDeviceScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.register_device), color = Color.White)
                },
                backgroundColor = Blue,
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            confirmNumberForm()
        }
    }
}

private fun LazyListScope.confirmNumberForm() {
    item {
        TigoTextField(
            title = R.string.phone_number,
            value = "255719526XXX",
            enabled = false
        )
        Spacer(modifier = Modifier.height(16.dp))
        GreenButton(title = R.string.phone_number, onClick = {})
    }
}