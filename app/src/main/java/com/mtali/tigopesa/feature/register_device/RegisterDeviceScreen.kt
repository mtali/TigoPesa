package com.mtali.tigopesa.feature.register_device

import androidx.activity.compose.BackHandler
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.component.GreenButton
import com.mtali.tigopesa.core.ui.component.OtpView
import com.mtali.tigopesa.core.ui.component.TigoTextField
import com.mtali.tigopesa.core.ui.component.height
import com.mtali.tigopesa.core.ui.theme.Blue
import com.mtali.tigopesa.core.ui.theme.LightGray

@Composable
fun RegisterDeviceRoute(
    viewModel: RegisterDeviceViewModel = hiltViewModel(),
    onDeviceRegistered: () -> Unit,
    onBackClick: () -> Unit
) {
    val showForm = viewModel.showForm

    RegisterDeviceScreen(
        onDeviceRegistered = onDeviceRegistered,
        showForm = showForm,
        onNumberConfirmed = viewModel::onNumberConfirmed,
        onBackClick = {
            viewModel.onBackClick(onBackClick)
        }
    )
}


@Composable
private fun RegisterDeviceScreen(
    showForm: Boolean,
    onDeviceRegistered: () -> Unit,
    onNumberConfirmed: () -> Unit,
    onBackClick: () -> Unit

) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.register_device), color = Color.White)
                },
                backgroundColor = Blue,
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
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
        ) {

            if (showForm) {
                height(16.dp)
                confirmNumberForm(onClickNext = { onNumberConfirmed() })
            } else {
                authCodeForm(onRegisterClick = onDeviceRegistered)
                item {
                    BackHandler(true) {
                        onBackClick()
                    }
                }

            }
        }
    }
}

@Composable
private fun Notice(modifier: Modifier = Modifier, @StringRes text: Int) {
    Row(
        modifier
            .fillMaxWidth()
            .background(LightGray.copy(alpha = 0.1f))
    ) {
        Text(
            text = stringResource(id = text),
            modifier = Modifier.padding(16.dp),
            fontSize = 10.sp,

            )
    }
}

private fun LazyListScope.authCodeForm(onRegisterClick: () -> Unit) {
    item {
        Notice(text = R.string.auth_sms_notice)
        Column(Modifier.padding(horizontal = 16.dp)) {
            Spacer(modifier = Modifier.height(16.dp))

            var code by remember { mutableStateOf("") }


            TigoTextField(
                title = R.string.authentication_code,
                value = code,
                enabled = true,
                onValueChange = {
                    code = it
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = stringResource(id = R.string.existing_tigo_pesa_pin))
            Spacer(modifier = Modifier.height(8.dp))
            OtpView()
            Spacer(modifier = Modifier.height(16.dp))

            TermsCheckbox(title = R.string.terms_condition_check_text)

            Spacer(modifier = Modifier.height(16.dp))

            GreenButton(
                title = R.string.register,
                onClick = onRegisterClick
            )


        }


    }
}

@Composable
fun TermsCheckbox(title: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = false,
            onCheckedChange = {},
            modifier = Modifier.absoluteOffset((-12).dp, 0.dp)
        )
        Text(text = stringResource(id = title), fontSize = 12.sp)
    }
}

private fun LazyListScope.confirmNumberForm(
    onClickNext: () -> Unit
) {
    item {
        Column(Modifier.padding(horizontal = 16.dp)) {
            TigoTextField(
                title = R.string.phone_number,
                value = "255719526XXX",
                enabled = false
            )
            Spacer(modifier = Modifier.height(16.dp))
            GreenButton(title = R.string.phone_number, onClick = onClickNext)
        }
    }
}